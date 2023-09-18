package br.com.fiap.healthtech.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Paciente (
    @SerializedName("pacienteId") val pacienteId: Int = 0,
    @SerializedName("pacienteName") val pacienteName: String = "",
    @SerializedName("cpf") val cpf: Long = 0,
    @SerializedName("pacienteEmail") val pacienteEmail: String = "",
    @SerializedName("pacienteSenha") val pacienteSenha: String = ""
)