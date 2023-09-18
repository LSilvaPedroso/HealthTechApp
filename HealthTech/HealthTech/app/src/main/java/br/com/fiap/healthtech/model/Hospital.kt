package br.com.fiap.healthtech.model

import com.google.gson.annotations.SerializedName

data class Hospital (
    @SerializedName("hospitalId") val hospitalId: Int = 0,
    @SerializedName("hospitalName") val hospitalName: String = "",
    @SerializedName("cnpj") val cnpj: Int = 0,
    @SerializedName("cep") val cep: Int = 0,
    @SerializedName("cidade") val cidade: String = "",
    @SerializedName("estado") val estado: String = "",
    @SerializedName("hospitalEndereco") val hospitalEndereco: String = ""

)