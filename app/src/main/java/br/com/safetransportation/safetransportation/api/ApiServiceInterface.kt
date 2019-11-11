package br.com.safetransportation.safetransportation.api

import android.provider.SyncStateContract
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Response
import okhttp3.OkHttpClient




interface ApiServiceInterface {

 /*   @GET("albums")
    fun getAlbumList(): Observable<List<Album>>

    @GET("albums/{id}")
    fun getAlbum(@Path("id") id: Int): Observable<Album>

    @DELETE("albums/{id}")
    fun deleteAlbum(@Path("id") id: Int)

    @GET("posts")
    fun getPostList(): Observable<List<Post>>

    @GET("posts/{id}")
    fun getPost(@Path("id") id: Int): Observable<Post>

    @DELETE("albums/{id}")
    fun deletePost(@Path("id") id: Int)

    @GET("posts/{id}")
    fun getUser(@Path("id") id: Int): Observable<User>

    @DELETE("albums/{id}")
    fun deleteUser(@Path("id") id: Int)

    @GET("users")
    fun getUserList(): Observable<List<User>> */

    @Headers(
        "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
        "Content-Type: text/html; charset=utf-8",
        "Accept-Language: pt_BR"
    )
    @GET("{link}")
    fun pegarJSONUber(@Path("link") id: String) : Observable<Response<ResponseBody>>


    companion object Factory {

        var gson = GsonBuilder().setLenient().create()
        fun createUber(): ApiServiceInterface {
                // Retrofit.Builder() : Classe responsável por construir um objeto do tipo Retrofit.

            val okHttpClient = OkHttpClient().newBuilder()
                .build()
                val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    // API Gson para conversão de objetos
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    // URL da API
                    .client(okHttpClient)
                    .baseUrl("https://trip.uber.com/")
                    // fINALIZAÇÃO DA CONFIGURAÇÃO BIULD.
                    .build()

                return retrofit.create(ApiServiceInterface::class.java) // Single-Expression function kotlin
            }
        }
}

