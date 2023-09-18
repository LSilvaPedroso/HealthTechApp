package br.com.fiap.healthtech.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Agenda (
    @SerializedName("agendaId") val agendaId: Int = 0,
    @SerializedName("pacienteId") val pacienteId: Int = 0,
    @SerializedName("medicoId") val medicoId: Int = 0,
    @SerializedName("dataEntrada") val dataEntrada: Date,
    @SerializedName("dataSaida") val dataSaida: Date,

)