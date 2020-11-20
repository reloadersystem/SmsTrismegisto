package com.reloader.smstrismegisto.domain

import com.reloader.smstrismegisto.data.MensajesDataSet
import com.reloader.smstrismegisto.ui.modelo.Mensajes

class MessageUseCase {

    private val messageUseCase = MensajesDataSet()

    fun obtenerListMessages(): List<Mensajes> {
        return messageUseCase.crearListDeMensajes()
    }
}