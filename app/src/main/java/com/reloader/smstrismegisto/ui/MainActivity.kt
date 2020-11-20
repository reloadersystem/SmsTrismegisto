package com.reloader.smstrismegisto.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.reloader.smstrismegisto.R
import com.reloader.smstrismegisto.ui.modelo.Mensajes
import com.reloader.smstrismegisto.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)

        val mensajesObserver = Observer<List<Mensajes>> {

//            for((index, value) in it.withIndex()){
//                Log.d("mensajes $index:", value.sms_mensaje) // 0:Kotlin , 1: iOS, 2: Flutter
//            }


//            for(mensaje in it){
//                Log.d("listaMensajes", mensaje.sms_mensaje)
//            } // result : Kotlin - iOS- Flutter- Java


            Log.d("listaMensajes", it.toString()) // list complete
        }

        viewModel.getListMensajesLiveData().observe(this, mensajesObserver)
    }
}
