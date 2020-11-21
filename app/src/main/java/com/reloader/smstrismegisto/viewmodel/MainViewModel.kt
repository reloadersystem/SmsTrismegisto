package com.reloader.smstrismegisto.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.reloader.smstrismegisto.domain.Repo
import com.reloader.smstrismegisto.vo.Resource
import kotlinx.coroutines.Dispatchers

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

}