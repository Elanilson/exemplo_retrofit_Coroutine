package br.com.apkdoandroid.retrofitcomcoroutines.entities

data class Comentario(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
) {
    override fun toString(): String {
        return "Comentario(body='$body', email='$email', id=$id, name='$name', postId=$postId)"
    }
}