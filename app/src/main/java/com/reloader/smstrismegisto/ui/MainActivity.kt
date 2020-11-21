package com.reloader.smstrismegisto.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.reloader.smstrismegisto.R
import com.reloader.smstrismegisto.data.DataSource
import com.reloader.smstrismegisto.domain.RepoImpl
import com.reloader.smstrismegisto.ui.modelo.Mensajes
import com.reloader.smstrismegisto.viewmodel.MainViewModel
import com.reloader.smstrismegisto.viewmodel.VMFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()

        btn_crearLista.setOnClickListener {
//            viewModel.getListMessages()
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this, VMFactory(RepoImpl(DataSource()))).get(MainViewModel::class.java)

//        val mensajesObserver = Observer<List<Mensajes>> {
//            Log.d("listaMensajes", it.toString()) // list complete
//        }
//        viewModel.getListMensajesLiveData().observe(this, mensajesObserver)
    }
}
