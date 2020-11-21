package com.reloader.smstrismegisto.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.reloader.smstrismegisto.R
import com.reloader.smstrismegisto.data.DataSource
import com.reloader.smstrismegisto.domain.RepoImpl
import com.reloader.smstrismegisto.viewmodel.MainViewModel
import com.reloader.smstrismegisto.viewmodel.VMFactory
import com.reloader.smstrismegisto.vo.Resource
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
        viewModel = ViewModelProviders.of(this, VMFactory(RepoImpl(DataSource())))
            .get(MainViewModel::class.java)

        viewModel.fetchMensajesList.observe(this, Observer { result ->
            when (result) {

                is Resource.Loading -> {
                    Log.v("chargeProgress", "ejecutar progress")
                }
                is Resource.Success -> {

                    Log.v("resultData", result.data.toString())
                }
                is Resource.Failure -> {
                    Toast.makeText(
                        this,
                        "Ocurrior un error al traer los datos ${result.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            }
        })

//        val mensajesObserver = Observer<Resource<List<Mensajes>>> {
//            Log.d("listaMensajes", it.toString()) // list complete
//        }
//        viewModel.fetchMensajesList.observe(this, mensajesObserver)
    }
}
