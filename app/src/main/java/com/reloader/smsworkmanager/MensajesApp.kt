package com.reloader.smsworkmanager

import android.app.Application
import androidx.room.Room

class MensajesApp :Application(){

    val room= Room
        .databaseBuilder(this, AppDatabase::class.java, "mensajes")
        .build()
}