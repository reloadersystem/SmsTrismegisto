package com.reloader.smsworkmanager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.reloader.smsworkmanager.domain.Repo
import com.reloader.smsworkmanager.ui.modelo.MensajeEntity
import com.reloader.smsworkmanager.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//pasando repo por Constructor
class MainViewModel(private val repo: Repo) : ViewModel() {

    //2do plano
    val fetchMensajesList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getMensajeslist())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun guardarMensaje(mensaje: MensajeEntity) {
        viewModelScope.launch {
            repo.insertMensaje(mensaje)
        }
    }

    fun getMensajesAllRoom() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getMensajesAll())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}