package com.reloader.smstrismegisto.domain.Servicios

import com.reloader.smstrismegisto.ui.modelo.MensajesList
import retrofit2.http.GET

interface WebService {

    @GET("listarSmsPendiente")
    suspend fun getDatosSMS(): MensajesList
}