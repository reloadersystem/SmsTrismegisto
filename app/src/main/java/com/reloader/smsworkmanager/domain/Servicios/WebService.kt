package com.reloader.smsworkmanager.domain.Servicios

import com.reloader.smsworkmanager.ui.modelo.MensajesList
import retrofit2.http.GET

interface WebService {

    @GET("listarSmsPendiente")
    suspend fun getDatosSMS(): MensajesList
}