package br.com.fiap.healthtech.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "https://9848-177-128-51-75.ngrok.io/api/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getHospitalService(): HospitalService {
        return retrofitFactory.create(HospitalService::class.java)
    }
    fun getAgendaService(): AgendaService {
        return retrofitFactory.create(AgendaService::class.java)
    }
    fun getMedicoService(): MedicoService {
        return retrofitFactory.create(MedicoService::class.java)
    }
    fun getPacienteService(): PacienteService {
        return retrofitFactory.create(PacienteService::class.java)
    }
}

