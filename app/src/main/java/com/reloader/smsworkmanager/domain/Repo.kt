package com.reloader.smsworkmanager.domain

import com.reloader.smsworkmanager.ui.modelo.MensajeEntity
import com.reloader.smsworkmanager.ui.modelo.Mensajes
import com.reloader.smsworkmanager.vo.Resource

interface Repo {
    suspend fun getMensajeslist(): Resource<List<Mensajes>>

    suspend fun getMensajesAll():Resource<List<MensajeEntity>>
    suspend fun insertMensaje(mensajes: MensajeEntity)


}