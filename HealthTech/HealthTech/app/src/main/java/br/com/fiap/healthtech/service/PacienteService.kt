package br.com.fiap.healthtech.service

import br.com.fiap.healthtech.model.Paciente
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PacienteService {
    @GET("Paciente/")
    fun getAllPaciente(): Call<List<Paciente>>

    @GET("Paciente/{id}/")
    fun getPacienteById(@Path("id") id: Int): Call<Paciente>

}