package com.reloader.smstrismegisto.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.reloader.smstrismegisto.domain.Repo
import com.reloader.smstrismegisto.vo.Resource
import kotlinx.coroutines.Dispatchers


class MainViewModel(private val repo: Repo) : ViewModel() {

    val fetchMensajesList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getMensajeslist())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}