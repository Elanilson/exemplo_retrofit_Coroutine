package br.com.apkdoandroid.retrofitcomcoroutines.entities

import com.google.gson.annotations.SerializedName

data class Postagem(
    @SerializedName("body")
    val descricao: String,
    val id: Int,
    val title: String,
    val userId: Int
) {
    override fun toString(): String {
        return "Postagem(descricao='$descricao', id=$id, title='$title', userId=$userId)"
    }
}