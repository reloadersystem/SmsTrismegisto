package com.reloader.smstrismegisto.domain

import com.reloader.smstrismegisto.data.DataSource
import com.reloader.smstrismegisto.ui.modelo.Mensajes
import com.reloader.smstrismegisto.vo.Resource

class RepoImpl(private val dataSource: DataSource) : Repo {

    override suspend fun getMensajeslist(): Resource<List<Mensajes>> {

        return dataSource.getMensajesService()
    }

}