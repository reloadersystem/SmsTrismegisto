package com.reloader.smstrismegisto.domain

import com.reloader.smstrismegisto.ui.modelo.Mensajes
import com.reloader.smstrismegisto.vo.Resource

interface Repo {
    fun getMensajeslist():Resource<List<Mensajes>>
}