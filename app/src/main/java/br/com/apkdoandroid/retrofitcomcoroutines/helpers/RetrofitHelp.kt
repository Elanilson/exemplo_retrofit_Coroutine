package br.com.apkdoandroid.retrofitcomcoroutines.helpers

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelp {

    companion object{
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://viacep.com.br/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitPleaseHolder = Retrofit
            .Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}