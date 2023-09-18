package br.com.fiap.healthtech.service

import br.com.fiap.healthtech.model.Hospital
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface HospitalService {
    //base: http://localhost:5215/
    //Hospitais: http://localhost:5215/api/Hospital

    @GET("Hospital/")
    fun getAllHospitals(): Call<List<Hospital>>

    @GET("Hospital/{id}/")
    fun getHospitalById(@Path("id") id: Int): Call<Hospital>

}