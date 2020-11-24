package com.reloader.smsworkmanager

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.reloader.smsworkmanager.domain.MensajesDao
import com.reloader.smsworkmanager.ui.modelo.MensajeEntity

@Database(entities = arrayOf(MensajeEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mensajeDao(): MensajesDao

    //se instancia una vez en toda la App
    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "sms_tabla"
            ).build()

            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }

    }

}