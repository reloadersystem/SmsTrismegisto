package com.reloader.smstrismegisto.ui.modelo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mensajes(
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