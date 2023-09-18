package br.com.fiap.healthtech.screens

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.fiap.healthtech.*
import br.com.fiap.healthtech.R
import br.com.fiap.healthtech.functions.MapearPessoas
import br.com.fiap.healthtech.model.Hospital
import br.com.fiap.healthtech.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListHospitalsScreen(navController: NavHostController) {
    var cepState by remember { mutableStateOf("") }
    var ufState by remember { mutableStateOf("") }
    var cidadeState by remember { mutableStateOf("") }
    var ruaState by remember { mutableStateOf("") }

    var listaHospital by remember {
        mutableStateOf(listOf<Hospital>())
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Card(modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.cinza_cl_ht)),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp
            )) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Encontre um Hospital",
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.azul_4_ht),
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Use a Pesquisa Detalhada",
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row() {
                    OutlinedTextField(
                        value = ufState,
                        onValueChange = {
                            ufState = it
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 4.dp),
                        label = {
                            Text(text = "UF?")
                        },
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Characters,
                            keyboardType = KeyboardType.Text
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = cidadeState,
                        onValueChange = {
                            cidadeState = it
                        },
                        modifier = Modifier.weight(2f),
                        label = {
                            Text(text = "Qual a cidade?")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            capitalization = KeyboardCapitalization.Words
                        )
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    OutlinedTextField(
                        value = ruaState,
                        onValueChange = {
                            ruaState = it
                        },
                        modifier = Modifier.weight(2f),
                        label = {
                            Text(text = "O que lembra do nome da rua?")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            capitalization = KeyboardCapitalization.Words
                        )
                    )
                    IconButton(onClick = {
                        var call = RetrofitFactory().getHospitalService().getAllHospitals()
                        call.enqueue(object : Callback<List<Hospital>>{
                            override fun onResponse(
                                call: Call<List<Hospital>>,
                                response: Response<List<Hospital>>
                            ) {
                                Log.i("API", "OnResponse: ${response.body()}")
                                listaHospital = response.body()!!
                            }

                            override fun onFailure(call: Call<List<Hospital>>, t: Throwable) {
                                Log.i("API", "OnResponse: ${t.message}")
                            }

                        })
                    }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "")
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn() {
            items(listaHospital) {
                CardEndereco(it)
            }
        }
    }
}

@Composable
fun CardEndereco(hospital: Hospital) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 4.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.cinza_cl_ht)),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
        ) {
            var pacientes = MapearPessoas(hospital)
            Text(
                text = "${hospital.hospitalName}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Row {
                Text(text = "${pacientes}")
                Icon(imageVector = Icons.Default.Face, contentDescription = "")
            }
            Text(text = "${hospital.hospitalEndereco}")
            Text(text = "${hospital.cidade} - ${hospital.cep}")

        }
    }
}