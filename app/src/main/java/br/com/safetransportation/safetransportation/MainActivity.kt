package br.com.safetransportation.safetransportation

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private var SMSReceiver: BroadcastReceiver? = null
    private val PERMISSION = 1
    private val MSGS_RECEBIDAS  = "android.provider.Telephony.SMS_RECEIVED"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verificarPermissoes();
    // bKYTpysR
     //   testeFirebase();

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
    }


    fun addLinkFirebase(link : String){
        val db = FirebaseFirestore.getInstance()

    // Add a new document with a generated ID
        db.collection("corridas")
            .add(hashMapOf("link" to link, "hora" to FieldValue.serverTimestamp()))
            .addOnSuccessListener { documentReference ->
                Log.d("ResultadoJFS", "DocumentSnapshot added with ID: ${documentReference.id}")
                Toast.makeText(this, "DocumentSnapshot added with ID: ${documentReference.id}", Toast.LENGTH_SHORT).show();
            }
            .addOnFailureListener { e ->
                Log.w("ResultadoJFS", "Error adding document", e)
                Toast.makeText(this, "Error adding document: $e", Toast.LENGTH_SHORT).show();

            }

        // .document("frank").db.update(updates).addOnCompleteListener { }

    }
    fun checkJSONUber(link: String) {

        Log.i("ResultadoJFS", link)
        addLinkFirebase(link);
    }

    fun verificarPermissoes(){

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECEIVE_SMS
            ) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_SMS
            ) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.INTERNET
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.RECEIVE_SMS,
                    Manifest.permission.READ_SMS,
                    Manifest.permission.INTERNET
                ),
                PERMISSION
            )
        }
    }
}
