package br.com.fiap.healthtech.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Medico (
    @SerializedName("medicoId") val medicoId: Int = 0,
    @SerializedName("medicoName") val medicoName: String = "",
    @SerializedName("crm") val crm: Int = 0,
    @SerializedName("dataNascimento") val dataNascimento: Date,
    @SerializedName("dataContratacao") val dataContratacao: Date,
    @SerializedName("hospital") val hospital: Hospital

)