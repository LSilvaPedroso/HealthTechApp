package br.com.fiap.healthtech.service

import br.com.fiap.healthtech.model.Agenda
import br.com.fiap.healthtech.model.Hospital
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AgendaService {
    @GET("Agenda/")
    fun getAllAgenda(): Call<List<Agenda>>

    @GET("Agenda/{id}/")
    fun getAgendaById(@Path("id") id: Int): Call<Agenda>

}