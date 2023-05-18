package br.com.apkdoandroid.retrofitcomcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import br.com.apkdoandroid.retrofitcomcoroutines.databinding.ActivityMainBinding
import br.com.apkdoandroid.retrofitcomcoroutines.entities.Endereco
import br.com.apkdoandroid.retrofitcomcoroutines.helpers.RetrofitHelp
import br.com.apkdoandroid.retrofitcomcoroutines.helpers.RetrofitHelp.Companion.retrofit
import br.com.apkdoandroid.retrofitcomcoroutines.helpers.services.ViaCep
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {
  //  private lateinit var retrofit : RetrofitHelp
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

     //   retrofit = RetrofitHelp()
    }

     fun executar(view : View){
        CoroutineScope(Dispatchers.IO).launch {
            recuperarEndereco("66120300")
        }
    }

    private suspend fun  recuperarEndereco(cep : String){
        var retorno : Response<Endereco>? = null
       try{
           val enderecoAPI = retrofit.create(ViaCep::class.java)
            retorno = enderecoAPI.recuperarEndereco2(cep)

           if(retorno != null){
               if(retorno.isSuccessful){

                   val endereco = retorno.body()
                   CoroutineScope(Dispatchers.Main).launch {
                       binding.textview.text = endereco.toString()
                   }

               }
           }

       }catch (e : Exception){
           e.message?.let { Log.d("ConsumoWeb", it) }
       }

    }
}