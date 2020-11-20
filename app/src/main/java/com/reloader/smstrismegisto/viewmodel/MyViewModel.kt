package com.reloader.smstrismegisto.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reloader.smstrismegisto.domain.MessageUseCase
import com.reloader.smstrismegisto.ui.modelo.Mensajes

class MyViewModel : ViewModel() {

    val mensajesUseCase = MessageUseCase()
    private val listData = MutableLiveData<List<Mensajes>>()

    init {
        //ni bien  hago la instancia de MyWiewModel inicia el metodo
        getListMessages()
    }

    fun setListSms(listaMessages: List<Mensajes>) {
        listData.value = listaMessages
    }

    fun getListMessages() {
        setListSms(mensajesUseCase.obtenerListMessages())
    }

    //escucha  si hay cambios
    fun getListMensajesLiveData():LiveData<List<Mensajes>>{
        return listData
    }

}