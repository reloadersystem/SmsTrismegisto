package com.reloader.smsworkmanager.ui.modelo

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mensajes(
    @SerializedName("sms_id")
    val sms_id: Int = 0,
    @SerializedName("sms_destinatario")
    val sms_destinatario: String = "",
    @SerializedName("sms_mensaje")
    val sms_mensaje: String = ""
) : Parcelable {
    override fun toString(): String {
        return "{sms_id=$sms_id, sms_destinatario='$sms_destinatario', sms_mensaje='$sms_mensaje'}"
    }
}

data class MensajesList(
    @SerializedName("data")
    val mensajesList: List<Mensajes>
) {
    override fun toString(): String {
        return "(mensajesList=$mensajesList)"
    }
}

@Entity(tableName = "sms_tabla")
data class MensajeEntity(
    @PrimaryKey
    @ColumnInfo(name = "sms_id")
    val sms_id: Int = 0,
    @ColumnInfo(name = "sms_destinatario")
    val sms_destinatario: String = "",
    @ColumnInfo(name = "sms_mensaje")
    val sms_mensaje: String = ""
)
