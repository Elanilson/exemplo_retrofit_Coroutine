package br.com.apkdoandroid.retrofitcomcoroutines.helpers.services

import br.com.apkdoandroid.retrofitcomcoroutines.entities.Endereco
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCep {
    @GET("ws/01001000/json/")
    suspend fun recuperarEndereco() : Response<Endereco>
    @GET("ws/{cep}/json/")
    suspend fun recuperarEndereco2(@Path("cep") cep : String) : Response<Endereco>
}