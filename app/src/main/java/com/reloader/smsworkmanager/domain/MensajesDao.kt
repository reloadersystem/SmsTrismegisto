package com.reloader.smsworkmanager.domain

import androidx.room.*
import com.reloader.smsworkmanager.ui.modelo.MensajeEntity

@Dao
interface MensajesDao {

    @Query("SELECT * FROM sms_tabla")
    suspend fun getAllMensajes(): List<MensajeEntity>

    @Query("SELECT * FROM sms_tabla WHERE sms_id")
    suspend fun getByID(): List<MensajeEntity>

    @Update
    suspend fun update(mensajeEntity: MensajeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMensajes(mensaje: MensajeEntity)

    @Delete
    suspend fun delete(mensajeEntity: MensajeEntity)


}