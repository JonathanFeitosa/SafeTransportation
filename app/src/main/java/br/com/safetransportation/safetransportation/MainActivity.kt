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
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import br.com.safetransportation.safetransportation.api.ApiServiceInterface
import br.com.safetransportation.safetransportation.modeluber.Uber
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import java.io.StringReader

class MainActivity : AppCompatActivity() {

    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.createUber()
    private var SMSReceiver: BroadcastReceiver? = null
    private val PERMISSION = 1
    private val MSGS_RECEBIDAS  = "android.provider.Telephony.SMS_RECEIVED"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verificarPermissoes();

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


    fun testeFirebase(){
        val db = FirebaseFirestore.getInstance()

    // Create a new user with a first and last name
        var user = hashMapOf(
                "first" to "Ada",
                "last" to "Lovelace",
                "born" to 1815
            )

    // Add a new document with a generated ID
            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d("ResultadoJFS", "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w("ResultadoJFS", "Error adding document", e)
                }

        // Create a new user with a first, middle, and last name
        user = hashMapOf(
            "first" to "Alan",
            "middle" to "Mathison",
            "last" to "Turing",
            "born" to 1912
        )

// Add a new document with a generated ID
        db.collection("corridas")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("ResultadoJFS", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("ResultadoJFS", "Error adding document", e)
            }
    }
    fun checkJSONUber(link: String) {

        Log.i("ResultadoJFS", link)

        subscriptions.add(
            api.pegarJSONUber(link)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ // onNex  t
                        result ->

                    val bais = ByteArrayInputStream((result.body() as ResponseBody).bytes())
                    val reader = InputStreamReader(bais)
                    val inx = BufferedReader(reader)

                    while (true) {
                        val readed = inx.readLine().replace("\\u0022", "\"") ?: break

                        if (readed.replace(" ", "").length > 8) {
                            if (readed.replace(" ", "").substring(0, 9).equals("{\"error\":")) {

                                if(!(readed.trimStart().contains("Unable to fetch the share link"))) {
                                    Log.e("JFSRESULTADO", "Success 3: ${readed.trimStart()}")

                                    var gson = Gson()
                                    var mMineUserEntity = gson?.fromJson(readed.trimStart(), Uber::class.java)

                                    Log.i("ResultadoJFS", mMineUserEntity.jobs.get1().status.toString());

                                }


                            }
                        }
                    }

                }, { error ->
                    // onError

                    Log.e("JFSRESULTADO", "Erro: ${error.localizedMessage}")

                })
        )
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
