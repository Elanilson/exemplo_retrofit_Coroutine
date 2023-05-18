package br.com.apkdoandroid.retrofitcomcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import br.com.apkdoandroid.retrofitcomcoroutines.entities.Comentario
import br.com.apkdoandroid.retrofitcomcoroutines.entities.Postagem
import br.com.apkdoandroid.retrofitcomcoroutines.helpers.RetrofitHelp.Companion.retrofit
import br.com.apkdoandroid.retrofitcomcoroutines.helpers.RetrofitHelp.Companion.retrofitPleaseHolder
import br.com.apkdoandroid.retrofitcomcoroutines.helpers.services.PostagemServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class JsonplaceholderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jsonplaceholder)
    }

      fun  recuperarPostagem (view : View){
          CoroutineScope(Dispatchers.IO).launch {
              //recuperarPostagems()
            //  recpuerarPost()
            //  recpuerarComentarioPost()
             // salvarPost()
            //  salvarPostFormlario()
              //putAtualizarPost()
              deletarPost()

          }
    }

    private suspend fun  recuperarPostagems(){
        var retorno : Response<List<Postagem>>? = null
        try{
            val retrofit = retrofitPleaseHolder.create(PostagemServices::class.java)
            retorno = retrofit.recuperarPostagens()

            if(retorno != null){
                if(retorno.isSuccessful){
                    retorno.body()?.forEach {
                        Log.d("Postagem",it.toString())
                    }
                }
            }

        }catch (e : Exception){
            e.printStackTrace()
        }
    }
    private suspend fun recpuerarPost(){
        var retorno : Response<Postagem>? = null
        try{
            val retrofit = retrofitPleaseHolder.create(PostagemServices::class.java)
            retorno = retrofit.recuperarPostagem(1)

            if(retorno != null){
                if(retorno.isSuccessful){
                        Log.d("Postagem",retorno.body().toString())

                }else{
                    Toast.makeText(this@JsonplaceholderActivity,retorno.message(),Toast.LENGTH_SHORT)

                }
            }else{
                Toast.makeText(this@JsonplaceholderActivity,"null",Toast.LENGTH_SHORT)
            }

        }catch (e : Exception){
            e.printStackTrace()
        }
    }

    private suspend fun recpuerarComentarioPost(){
        var retorno : Response<List<Comentario>>? = null
        try{
            val retrofit = retrofitPleaseHolder.create(PostagemServices::class.java)
           // retorno = retrofit.recuperarComentarioDaPostagem(1)
            retorno = retrofit.recuperarComentarioDaPostagemQuery(1)

            if(retorno != null){
                if(retorno.isSuccessful){
                    retorno.body()?.forEach {
                        Log.d("Postagem",it.toString())
                    }

                }else{
                    Toast.makeText(this@JsonplaceholderActivity,retorno.message(),Toast.LENGTH_SHORT)

                }
            }else{
                Toast.makeText(this@JsonplaceholderActivity,"null",Toast.LENGTH_SHORT)
            }

        }catch (e : Exception){
            e.printStackTrace()
        }
    }

    private suspend fun salvarPost(){
        var retorno : Response<Postagem>? = null
        try{
            val retrofit = retrofitPleaseHolder.create(PostagemServices::class.java)
            val postagem = Postagem("oiiii",0,"teste",125)
            retorno = retrofit.salvarPost(postagem)

            if(retorno != null){
                if(retorno.isSuccessful){
                    Log.d("Postagem",retorno.body().toString())

                }else{
                    Toast.makeText(this@JsonplaceholderActivity,retorno.message(),Toast.LENGTH_SHORT)

                }
            }else{
                Toast.makeText(this@JsonplaceholderActivity,"null",Toast.LENGTH_SHORT)
            }

        }catch (e : Exception){
            e.printStackTrace()
        }
    }

    private suspend fun salvarPostFormlario(){
        var retorno : Response<Postagem>? = null
        try{
            val retrofit = retrofitPleaseHolder.create(PostagemServices::class.java)

            retorno = retrofit.salvarPostFormulario(0,"teste 2","teste 3",157)

            if(retorno != null){
                if(retorno.isSuccessful){
                    Log.d("Postagem",retorno.body().toString())

                }else{
                    Toast.makeText(this@JsonplaceholderActivity,retorno.message(),Toast.LENGTH_SHORT)

                }
            }else{
                Toast.makeText(this@JsonplaceholderActivity,"null",Toast.LENGTH_SHORT)
            }

        }catch (e : Exception){
            e.printStackTrace()
        }
    }

    private suspend fun putAtualizarPost(){
        var retorno : Response<Postagem>? = null
        try{
            val retrofit = retrofitPleaseHolder.create(PostagemServices::class.java)
            val postagem = Postagem("oiiii",0,"teste",125)
            retorno = retrofit.atualizarPost(100,postagem)

            if(retorno != null){
                if(retorno.isSuccessful){
                    Log.d("Postagem",retorno.body().toString())

                }else{
                    Toast.makeText(this@JsonplaceholderActivity,retorno.message(),Toast.LENGTH_SHORT)

                }
            }else{
                Toast.makeText(this@JsonplaceholderActivity,"null",Toast.LENGTH_SHORT)
            }

        }catch (e : Exception){
            e.printStackTrace()
        }
    }


    private suspend fun pathAtualizarPost(){
        var retorno : Response<Postagem>? = null
        try{
            val retrofit = retrofitPleaseHolder.create(PostagemServices::class.java)
            val postagem = Postagem("oiiii",0,"",0)
            retorno = retrofit.atualizarPost(100,postagem)

            if(retorno != null){
                if(retorno.isSuccessful){
                    Log.d("Postagem",retorno.body().toString())

                }else{
                    Toast.makeText(this@JsonplaceholderActivity,retorno.message(),Toast.LENGTH_SHORT)

                }
            }else{
                Toast.makeText(this@JsonplaceholderActivity,"null",Toast.LENGTH_SHORT)
            }

        }catch (e : Exception){
            e.printStackTrace()
        }
    }

    private suspend fun deletarPost(){
        var retorno : Response<Postagem>? = null
        try{
            val retrofit = retrofitPleaseHolder.create(PostagemServices::class.java)
            retorno = retrofit.deletarPost(100)

            if(retorno != null){
                if(retorno.isSuccessful){
                    Log.d("Postagem",retorno.body().toString())

                }else{
                    Toast.makeText(this@JsonplaceholderActivity,retorno.message(),Toast.LENGTH_SHORT)

                }
            }else{
                Toast.makeText(this@JsonplaceholderActivity,"null",Toast.LENGTH_SHORT)
            }

        }catch (e : Exception){
            e.printStackTrace()
        }
    }

}