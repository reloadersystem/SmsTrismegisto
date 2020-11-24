package com.reloader.smsworkmanager.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.reloader.smsworkmanager.AppDatabase
import com.reloader.smsworkmanager.R
import com.reloader.smsworkmanager.data.DataSource
import com.reloader.smsworkmanager.domain.RepoImpl
import com.reloader.smsworkmanager.ui.modelo.MensajeEntity
import com.reloader.smsworkmanager.ui.modelo.Mensajes
import com.reloader.smsworkmanager.viewmodel.MainViewModel
import com.reloader.smsworkmanager.viewmodel.VMFactory
import com.reloader.smsworkmanager.vo.Resource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MensajesRecyclerAdapter.OnMensajesClickListener {


    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        btn_guardarlista.setOnClickListener {

            viewModel.guardarMensaje(
                MensajeEntity(
                    sms_id = 4891,
                    sms_mensaje = "157899",
                    sms_destinatario = "+519999938"
                )
            )
            Toast.makeText(applicationContext, "se guardo exitosamente", Toast.LENGTH_SHORT).show()

            viewModel.getMensajesAllRoom().observe(this, Observer { result ->
                when (result) {

                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {

                        Log.v("resultDB", result.data.toString())

                    }
                    is Resource.Failure -> {
                        Toast.makeText(
                            this,
                            "Ocurrio un error al traer los datos ${result.exception}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
            )
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            VMFactory(RepoImpl(DataSource(AppDatabase.getDatabase(this))))
        )
            .get(MainViewModel::class.java)

        viewModel.fetchMensajesList.observe(this, Observer { result ->
            when (result) {

                is Resource.Loading -> {
                    Log.v("chargeProgress", "ejecutar progress")
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progressBar.visibility = View.GONE
                    Log.v("resultData", result.data.toString())
                    rc_mensajes.layoutManager = LinearLayoutManager(applicationContext)
                    rc_mensajes.setHasFixedSize(true)
                    val mensajesRecyclerAdapter = MensajesRecyclerAdapter(result.data, this)
                    rc_mensajes.adapter = mensajesRecyclerAdapter

                }
                is Resource.Failure -> {
                    progressBar.visibility = View.GONE
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
        Toast.makeText(
            applicationContext,
            "position $position  ${mensaje.get(position).sms_mensaje}",
            Toast.LENGTH_SHORT
        ).show()
    }
}
