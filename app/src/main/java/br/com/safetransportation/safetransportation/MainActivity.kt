package br.com.safetransportation.safetransportation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
import br.com.safetransportation.safetransportation.api.ApiServiceInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import java.io.StringReader
import it.xabaras.android.smsinterceptor.SmsInterceptor
import java.util.regex.Pattern
import android.R.attr.phoneNumber
import android.telephony.SmsManager


class MainActivity : AppCompatActivity() {

    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.createUber()
    private val OTP_PATTERN = Pattern.compile("^(\\d{4}) is the OTP for your App.$")
    private var smsInterceptor : SmsInterceptor = SmsInterceptor(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkJSONUber("3UbHVT9eAkg0b")
        var smsInterceptor = SmsInterceptor(this)


        val sms = SmsManager.getDefault()

        smsInterceptor.setBodyFilter {
            it.startsWith("Estou")
        }

        smsInterceptor.startListening { fromNumber, message ->
          //  Log.i("Resultado", fromNumber)
            Log.i("Resultado", message)
            if(message.contains("Estou indo de 99POP") || message.contains("Estou a caminho")) {
            //    Log.i("Resultado", message)
            }
        }
    }



    //   var novaMsg = message
    //    if(message.contains("didiglobal") || message.contains("uber")){
    //Log.i("Resultado", "Resulotado: $message ")
    // }
    override fun onResume() {
        super.onResume()
//        smsInterceptor.resumeListening()


    }

    override fun onPause() {
        super.onPause()
      //  smsInterceptor.stopListening()
    }


    fun checkJSONUber(link: String) {

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
                                Log.e("JFSRESULTADO", "Success 3: ${readed.trimStart()}")

                                var stringReader: StringReader = StringReader(readed.trimStart())
                                //    var jsonReader: JsonReader = JsonReader(stringReader)

                                //   val gsonBuilder = GsonBuilder().serializeNulls()
                                //    gsonBuilder.registerTypeAdapter(WeatherObject::class.java, WeatherDeserializer())
                                //   val gson = gsonBuilder.create()

                                //      val weatherList: List<WeatherObject> = gson.fromJson(stringReader , Array<WeatherObject>::class.java).toList()

                            }
                        }


                    }


                }, { error ->
                    // onError

                    Log.e("JFSRESULTADO", "Erro: ${error.localizedMessage}")
/*
                    if (error is HttpException) {
                        val errorJsonString = error.response()!!
                            .errorBody()?.string()
                    } */

                })
        )
    }
}
