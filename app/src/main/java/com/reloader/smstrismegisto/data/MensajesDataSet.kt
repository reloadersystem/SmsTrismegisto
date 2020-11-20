package com.reloader.smstrismegisto.data

import com.reloader.smstrismegisto.ui.modelo.Mensajes

class MensajesDataSet {

    fun crearListDeMensajes(): List<Mensajes> {

        return listOf(
            Mensajes(10, "+519641548", "Kotlin"),
            Mensajes(11, "+5191212125", "iOS"),
            Mensajes(12, "+5112312344", "Flutter"),
            Mensajes(13, "+5658587900", "Java")
        )
    }
}