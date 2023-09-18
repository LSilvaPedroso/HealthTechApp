package br.com.fiap.healthtech.functions

import android.util.Log
import androidx.compose.runtime.Composable
import br.com.fiap.healthtech.model.Agenda
import br.com.fiap.healthtech.model.Hospital
import br.com.fiap.healthtech.model.Medico
import br.com.fiap.healthtech.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun MapearPessoas(listaHospital: Hospital): Int {
    var iHospitalPacientes = 0

    var call = RetrofitFactory().getAgendaService().getAllAgenda()
    call.enqueue(object : Callback<List<Agenda>> {
        override fun onResponse(
            call: Call<List<Agenda>>,
            responseAgenda: Response<List<Agenda>>
        ) {
            Log.i("APIRes", "OnResponse: ${responseAgenda.body()}")
            var pacientes = responseAgenda.body()!!

            var callMedico = RetrofitFactory().getMedicoService().getAllMedico()
            callMedico.enqueue(object : Callback<List<Medico>> {
                override fun onResponse(
                    call: Call<List<Medico>>,
                    responseMedico: Response<List<Medico>>
                ) {
                    Log.i("APIRes", "OnResponse: ${responseMedico.body()}")
                    var medicos = responseMedico.body()!!

                    for (paciente in pacientes){
                        for (medico in medicos){
                            if (paciente.medicoId == medico.medicoId && medico.hospital.hospitalId == listaHospital.hospitalId){
                                iHospitalPacientes++
                            }
                        }
                    }

                }

                override fun onFailure(call: Call<List<Medico>>, t: Throwable) {
                    Log.i("APIRes", "OnResponse: ${t.message}")
                }

            })
        }

        override fun onFailure(call: Call<List<Agenda>>, t: Throwable) {
            Log.i("APIRes", "OnResponse: ${t.message}")
        }

    })
    return iHospitalPacientes
}