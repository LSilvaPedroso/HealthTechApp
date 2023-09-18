package br.com.fiap.healthtech.service

import br.com.fiap.healthtech.model.Agenda
import br.com.fiap.healthtech.model.Medico
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MedicoService {
    @GET("Medico/")
    fun getAllMedico(): Call<List<Medico>>

    @GET("Medico/{id}/")
    fun getMedicoById(@Path("id") id: Int): Call<Medico>

}