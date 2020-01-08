package br.com.safetransportation.safetransportation

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Build
import android.os.Handler
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast
import androidx.core.app.JobIntentService
import androidx.core.app.NotificationCompat
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class MyJobIntentService : JobIntentService() {

    private val mHandler : Handler = Handler();
    private var SMSReceiver: BroadcastReceiver? = null
    private val MSGS_RECEBIDAS  = "android.provider.Telephony.SMS_RECEIVED"


    companion object {

        fun enqueueWork(context: Context, work: Intent) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(work)
            } else {
                context.startService(work)
            }
            enqueueWork(context, MyJobIntentService::class.java, 1000, work)
        }
    }

    override fun onHandleWork(intent: Intent) {

        // bKYTpysR
        val intentFilter = IntentFilter()
        intentFilter.addAction(MSGS_RECEBIDAS)

        SMSReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val bundle = intent.extras
                var str = ""
                //         var phoneNumber = ""
                if (bundle != null) {

                    var msgs: Array<SmsMessage?>
                    val pdus = bundle.get("pdus") as Array<Any>?
                    msgs = arrayOfNulls(pdus!!.size)
                    for (i in msgs.indices) {
                        msgs[i] = SmsMessage.createFromPdu(pdus!![i] as ByteArray)
                        str += msgs[i]!!.messageBody.toString()
                        // phoneNumber = msgs[i]!!.originatingAddress!!.toString()
                    }
                    if(str.contains("pop")|| str.contains("POP")){


                    }
                    else if (str.contains("UBER") || str.contains("uber")){

                        var i = 0
                        var position = 0;

                        for (item: Char in str) {
                            if(item.toString().equals("/") || item.toString().equals('/')){
                                position = i;
                            }
                            i+=1;
                        }
                        if(position != 0) checkJSONUber(str.substring(position+1, str.length))

                    }
                    //  Log.i("ResultadoJFS", phoneNumber)
                }
            }
        }
        registerReceiver(SMSReceiver, intentFilter)
        toast("SafeTransportation - Service initialized")
        Log.i("ResultadoJFS", "onHandleWork()")

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("ResultadoJFS", "onStartCommand()")

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val NOTIFICATION_CHANNEL_ID = "br.com.safetransportation.safetransportation"
            val channelName = "Background Service"
            val chan = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                channelName,
                NotificationManager.IMPORTANCE_NONE
            )
            chan.lightColor = Color.BLUE
            chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(chan)

            val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            val notification = notificationBuilder.setOngoing(true)
                //   .setSmallIcon(AppSpecific.SMALL_ICON)
                .setContentTitle("App is running in background")
                .setPriority(NotificationManager.IMPORTANCE_MIN)
                .setCategory(Notification.CATEGORY_SERVICE)
                .build()
            startForeground(2, notification)
        }
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            unregisterReceiver(SMSReceiver)
        } catch (e: Exception) {
            e.fillInStackTrace()
        }

        Log.wtf("ResultadoJFS", "SafeTransportation - Service finalized")
        toast("SafeTransportation - Service finalized")
    }


    private fun toast(text: CharSequence) {
        mHandler.post { Toast.makeText(this, text, Toast.LENGTH_SHORT).show() }
    }

    fun addLinkFirebase(link : String){
        val db = FirebaseFirestore.getInstance()

    // Add a new document with a generated ID
        db.collection("corridas")
            .add(hashMapOf("link" to link, "hora" to FieldValue.serverTimestamp()))
            .addOnSuccessListener { documentReference ->
                Log.d("ResultadoJFS", "DocumentSnapshot added with ID: ${documentReference.id}")
             //   Toast.makeText(this, "DocumentSnapshot added with ID: ${documentReference.id}", Toast.LENGTH_SHORT).show();
            }
            .addOnFailureListener { e ->
                Log.w("ResultadoJFS", "Error adding document", e)
            //    Toast.makeText(this, "Error adding document: $e", Toast.LENGTH_SHORT).show();

            }

        // .document("frank").db.update(updates).addOnCompleteListener { }

    }
    fun checkJSONUber(link: String) {
        Log.i("ResultadoJFS", link)
        addLinkFirebase(link);
    }

}
