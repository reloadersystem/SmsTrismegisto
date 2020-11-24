package com.reloader.smsworkmanager.vo

import com.google.gson.GsonBuilder
import com.reloader.smsworkmanager.domain.Servicios.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitClient {

    val webservice by lazy {

        Retrofit.Builder()
            .baseUrl("http://192.169.218.177:8080/FacturacionElectronicaSIIAA/api/v1/estudiante/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}