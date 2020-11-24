package com.reloader.smsworkmanager.data

import com.reloader.smsworkmanager.AppDatabase
import com.reloader.smsworkmanager.ui.modelo.MensajeEntity
import com.reloader.smsworkmanager.ui.modelo.Mensajes
import com.reloader.smsworkmanager.vo.Resource
import com.reloader.smsworkmanager.vo.RetrofitClient

class DataSource(private val appDatabase: AppDatabase) {

    suspend fun getMensajesService(): Resource<List<Mensajes>> {
        return Resource.Success(RetrofitClient.webservice.getDatosSMS().mensajesList)
    }

    suspend fun insertMensajeRoom(mensaje: MensajeEntity) {
        appDatabase.mensajeDao().insertMensajes(mensaje)
    }

    suspend fun getMensajeRoomAll(): Resource<List<MensajeEntity>> {

        return Resource.Success(appDatabase.mensajeDao().getAllMensajes())
    }

}