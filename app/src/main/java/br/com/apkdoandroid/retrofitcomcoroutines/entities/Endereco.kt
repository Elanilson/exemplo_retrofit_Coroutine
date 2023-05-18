package br.com.apkdoandroid.retrofitcomcoroutines.entities

data class Endereco(
    val bairro: String,
    val cep: String,
    val complemento: String,
    val ddd: String,
    val gia: String,
    val ibge: String,
    val localidade: String,
    val logradouro: String,
    val siafi: String,
    val uf: String


) {
    override fun toString(): String {
        return "Endereco(bairro='$bairro', cep='$cep', complemento='$complemento', ddd='$ddd', gia='$gia', ibge='$ibge', localidade='$localidade', logradouro='$logradouro', siafi='$siafi', uf='$uf')"
    }
}