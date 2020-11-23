package com.reloader.smstrismegisto.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.reloader.smstrismegisto.R
import com.reloader.smstrismegisto.ui.modelo.Mensajes


class MensajesRecyclerAdapter(
    private val mensaje: List<Mensajes>,
    private val itemClickListener: OnMensajesClickListener
) :
    RecyclerView.Adapter<MensajesRecyclerAdapter.MyViewHolderSms>() {

    interface OnMensajesClickListener {
        fun onMensajesClick(
            position: Int,
            mensaje: List<Mensajes>
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolderSms {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mensajes_row, parent, false)
        return MyViewHolderSms(view)
    }

    override fun getItemCount(): Int {
        return mensaje.size
    }

    override fun onBindViewHolder(holder: MyViewHolderSms, position: Int) {

        holder.destinatario.text = mensaje[position].sms_destinatario
        holder.id.text = mensaje[position].sms_id.toString()
        holder.msg.text = mensaje[position].sms_mensaje

    }

    inner class MyViewHolderSms(val view: View) :
        RecyclerView.ViewHolder(view) {

        val id: TextView = itemView.findViewById(R.id.txt_id)
        val destinatario: TextView = itemView.findViewById(R.id.txt_destinatario)
        val msg: TextView = itemView.findViewById(R.id.txt_mensaje)

        init {

            view.setOnClickListener {
                itemClickListener.onMensajesClick( position, mensaje)
            }
        }


    }
}