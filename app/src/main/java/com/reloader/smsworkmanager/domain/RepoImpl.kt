package com.reloader.smsworkmanager.domain

import com.reloader.smsworkmanager.data.DataSource
import com.reloader.smsworkmanager.ui.modelo.MensajeEntity
import com.reloader.smsworkmanager.ui.modelo.Mensajes
import com.reloader.smsworkmanager.vo.Resource

class RepoImpl(private val dataSource: DataSource) : Repo {

    override suspend fun getMensajeslist(): Resource<List<Mensajes>> {

        return dataSource.getMensajesService()
    }

    override suspend fun insertMensaje(mensajes: MensajeEntity) {
        dataSource.insertMensajeRoom(mensajes)
    }

    override suspend fun getMensajesAll(): Resource<List<MensajeEntity>> {
       return dataSource.getMensajeRoomAll()
    }


}