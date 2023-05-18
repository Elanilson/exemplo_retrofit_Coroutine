package br.com.apkdoandroid.retrofitcomcoroutines.helpers.services

import br.com.apkdoandroid.retrofitcomcoroutines.entities.Comentario
import br.com.apkdoandroid.retrofitcomcoroutines.entities.Postagem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface PostagemServices {
    @GET("posts")
    suspend fun recuperarPostagens() : Response<List<Postagem>>

    @GET("posts/{id}")
    suspend fun recuperarPostagem(@Path("id") id : Int) : Response<Postagem>

    @GET("posts/{id}/comments")
    suspend fun recuperarComentarioDaPostagem(@Path("id") id : Int) : Response<List<Comentario>>

    @GET("comments")
    suspend fun recuperarComentarioDaPostagemQuery(@Query("postId") id : Int) : Response<List<Comentario>>

    @POST("posts/")
    suspend fun salvarPost(@Body postagem : Postagem) : Response<Postagem>

    @POST("posts/")
    @FormUrlEncoded
    suspend fun salvarPostFormulario(
        @Field("id") id : Int,
        @Field("title") title : String,
        @Field("body") body : String,
        @Field("userId") userId : Int
    ) : Response<Postagem>

    @PUT("posts/{id}") // completa
    suspend fun atualizarPost(
        @Path("id") id : Int,
        @Body postagem : Postagem) : Response<Postagem>

    @PUT("posts/{id}") // atualizar parcialmente, apenas do dados enviados
    suspend fun atualizarPatchPost(
        @Path("id") id : Int,
        @Body postagem : Postagem) : Response<Postagem>

    @DELETE("posts/{id}") // atualizar parcialmente, apenas do dados enviados
    suspend fun deletarPost(
        @Path("id") id : Int) : Response<Postagem>
}