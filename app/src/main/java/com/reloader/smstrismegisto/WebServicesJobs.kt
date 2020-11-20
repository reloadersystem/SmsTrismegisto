package com.reloader.smstrismegisto

import android.app.job.JobParameters
import android.app.job.JobService
import android.telephony.SmsManager

class WebServicesJobs : JobService() {

    private lateinit var sms: SmsManager
    private var jobCancelled = false


    private fun doBackWork(jobParameters: JobParameters?) {
        revisarPendientes()
    }



    override fun onStartJob(jobParameters: JobParameters?): Boolean {
        sms = SmsManager.getDefault()

        doBackWork(jobParameters)

        return true
    }

    override fun onStopJob(jobParameters: JobParameters?): Boolean {
        jobCancelled = true
        return true
    }

    private fun revisarPendientes() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}