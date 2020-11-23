package com.reloader.smstrismegisto.data

import com.reloader.smstrismegisto.ui.modelo.Mensajes
import com.reloader.smstrismegisto.vo.Resource
import com.reloader.smstrismegisto.vo.RetrofitClient

class DataSource {

    suspend fun getMensajesService():Resource<List<Mensajes>>{
        return Resource.Success(RetrofitClient.webservice.getDatosSMS().mensajesList)
    }
}