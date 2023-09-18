package br.com.fiap.healthtech.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.healthtech.R
import br.com.fiap.healthtech.components.CaixaDeEntrada
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.healthtech.model.Hospital
import br.com.fiap.healthtech.model.Paciente
import br.com.fiap.healthtech.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen(navController: NavController) {

    var cpf by remember {
        mutableStateOf("")
    }
    var senha by remember {
        mutableStateOf("")
    }
    var errorCpf by remember {
        mutableStateOf(false)
    }
    var errorSenha by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.cinza_cl_ht))
        ) {
            // ---- header ---------
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_logo_ms),
                    contentDescription = stringResource(id = R.string.imageMSDescription),
                    modifier = Modifier
                        .size(150.dp)
                        .offset(x = (-80).dp)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-30).dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.titleAppLogin),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Image(
                        painter = painterResource(id = R.drawable.equipe_medica),
                        contentDescription = stringResource(id = R.string.imageDoctorsDescription),
                        modifier = Modifier.size(160.dp)
                    )
                }
            }
            // --- formulário
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.cinza_cl_ht)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                ) {
                    // --- formulário
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(
                                vertical = 16.dp,
                                horizontal = 32.dp
                            )
                        ) {
                            Text(
                                text = stringResource(id = R.string.login),
                                modifier = Modifier.fillMaxWidth(),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.azul_4_ht),
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(32.dp))

                            val modifierTextDefinition = Modifier.fillMaxWidth()

                            CaixaDeEntrada(
                                label = stringResource(id = R.string.cpfLabel),
                                placeHolder = "Ex: 123.456.789-00",
                                value = cpf,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                modifier = modifierTextDefinition,
                                atualizarValor = {
                                    if (cpf.length != 11 || it.length < cpf.length) {
                                        cpf = it
                                    }
                                },
                                singleLine = true,
                                visualTransformation = VisualTransformation.None,
                                isError = errorCpf
                            )
                            if (errorCpf){
                                Text(
                                    text = stringResource(id = R.string.cpfValidation),
                                    modifier = Modifier.fillMaxWidth(),
                                    fontSize = 12.sp,
                                    color = Color.Red,
                                    textAlign = TextAlign.End
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))

                            var pwdMaxLength = 32
                            CaixaDeEntrada(
                                label = stringResource(id = R.string.passwordLabel),
                                placeHolder = stringResource(id = R.string.passwordPlaceHolder),
                                value = senha,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                modifier = modifierTextDefinition,
                                atualizarValor = {
                                    if (senha.length <= pwdMaxLength || it.length < senha.length) {
                                        senha = it
                                    }
                                },
                                singleLine = true,
                                visualTransformation = PasswordVisualTransformation(),
                                isError = errorSenha
                            )
                            if (errorSenha){
                                Text(
                                    text = stringResource(id = R.string.validationEmpty),
                                    modifier = Modifier.fillMaxWidth(),
                                    fontSize = 12.sp,
                                    color = Color.Red,
                                    textAlign = TextAlign.End
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))

                            Button(
                                onClick = {
                                    val regex = Regex("^[0-9]+$")
                                    errorCpf = cpf.isNullOrEmpty() || cpf.length <  11 || !(cpf.matches(regex))
                                    errorSenha = senha.isNullOrEmpty()
                                    var listaPaciente: List<Paciente>

                                    var call = RetrofitFactory().getPacienteService().getAllPaciente()
                                    call.enqueue(object : Callback<List<Paciente>> {
                                        override fun onResponse(
                                            call: Call<List<Paciente>>,
                                            response: Response<List<Paciente>>
                                        ) {
                                            Log.i("API", "OnResponse: ${response.body()}")
                                            listaPaciente = response.body()!!
                                            for (paciente in listaPaciente){
                                                Log.i("API", "OnResponse: ${paciente}")
                                                if(paciente.cpf == cpf.toLong()){
                                                    if(paciente.pacienteSenha != senha){
                                                        navController.navigate("hospitals")
                                                    }
                                                }
                                            }
                                        }

                                        override fun onFailure(call: Call<List<Paciente>>, t: Throwable) {
                                            Log.i("API", "OnResponse: ${t.message}")
                                        }

                                    })

                                    if (!(errorCpf || errorSenha)){
                                        navController.navigate("hospitals")
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(
                                        id = R.color.azul_4_ht
                                    )
                                )
                            ) {
                                Text(
                                    text = stringResource(id = R.string.enter),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 14.sp
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = {
                                    navController.navigate("cadastro")
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(
                                        id = R.color.azul_4_ht
                                    )
                                )
                            ) {
                                Text(
                                    text = stringResource(id = R.string.register),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 14.sp
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }
                }
            }
        }
        // -- Card Resultado
    }
}

//@Preview
//@Composable
//fun LoginScreenPreview() {
//    LoginScreen()
//}