package com.reloader.smstrismegisto.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.reloader.smstrismegisto.R
import com.reloader.smstrismegisto.data.DataSource
import com.reloader.smstrismegisto.domain.RepoImpl
import com.reloader.smstrismegisto.ui.modelo.Mensajes
import com.reloader.smstrismegisto.viewmodel.MainViewModel
import com.reloader.smstrismegisto.viewmodel.VMFactory
import com.reloader.smstrismegisto.vo.Resource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MensajesRecyclerAdapter.OnMensajesClickListener {


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
                    rc_mensajes.layoutManager = LinearLayoutManager(applicationContext)
                    rc_mensajes.setHasFixedSize(true)
                    val mensajesRecyclerAdapter = MensajesRecyclerAdapter(result.data, this)
                    rc_mensajes.adapter = mensajesRecyclerAdapter

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
    }

    override fun onMensajesClick(
        position: Int,
        mensaje: List<Mensajes>
    ) {
        Toast.makeText(applicationContext, "position $position  ${mensaje.get(position).sms_mensaje}", Toast.LENGTH_SHORT).show()
    }
}
