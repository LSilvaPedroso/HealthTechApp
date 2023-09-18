package br.com.fiap.healthtech.screens

import androidx.compose.foundation.*
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.healthtech.*
import br.com.fiap.healthtech.R
import br.com.fiap.healthtech.components.CaixaDeEntrada

@Composable
fun CadastroScreen(navController: NavController) {

    var nomeCompleto by remember {
        mutableStateOf("")
    }
    var cpf by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var senha by remember {
        mutableStateOf("")
    }
    var confirmaSenha by remember {
        mutableStateOf("")
    }
    var errorNomeCompleto by remember {
        mutableStateOf(false)
    }
    var errorCpf by remember {
        mutableStateOf(false)
    }
    var errorEmail by remember {
        mutableStateOf(false)
    }
    var errorSenha by remember {
        mutableStateOf(false)
    }
    var errorConfirmaSenha by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.cinza_cl_ht))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.Center)
        ) {
            // --- formulário
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
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
                            .padding(horizontal = 32.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(
                                vertical = 16.dp,
                                horizontal = 32.dp
                            )
                        ) {
                            Text(
                                text = stringResource(id = R.string.registerForm),
                                modifier = Modifier.fillMaxWidth(),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.azul_4_ht),
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(32.dp))
                            var modifierTextDefinition = Modifier.fillMaxWidth()

                            CaixaDeEntrada(
                                label = stringResource(id = R.string.nameLabel),
                                placeHolder = "Ex: Joao Silva",
                                value = nomeCompleto,
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text,
                                    capitalization = KeyboardCapitalization.Words
                                ),
                                modifier = modifierTextDefinition,
                                atualizarValor = {
                                    nomeCompleto = it
                                },
                                singleLine = true,
                                visualTransformation = VisualTransformation.None,
                                isError = errorNomeCompleto
                            )
                            if (errorNomeCompleto) {
                                if (nomeCompleto.isNullOrEmpty()) {
                                    Text(
                                        text = stringResource(id = R.string.validationEmpty),
                                        modifier = Modifier.fillMaxWidth(),
                                        fontSize = 12.sp,
                                        color = Color.Red,
                                        textAlign = TextAlign.End
                                    )
                                } else {
                                    Text(
                                        text = stringResource(id = R.string.nameValidation),
                                        modifier = Modifier.fillMaxWidth(),
                                        fontSize = 12.sp,
                                        color = Color.Red,
                                        textAlign = TextAlign.End
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))

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
                            if (errorCpf) {
                                if (cpf.isNullOrEmpty()) {
                                    Text(
                                        text = stringResource(id = R.string.validationEmpty),
                                        modifier = Modifier.fillMaxWidth(),
                                        fontSize = 12.sp,
                                        color = Color.Red,
                                        textAlign = TextAlign.End
                                    )
                                } else {
                                    Text(
                                        text = stringResource(id = R.string.cpfValidation),
                                        modifier = Modifier.fillMaxWidth(),
                                        fontSize = 12.sp,
                                        color = Color.Red,
                                        textAlign = TextAlign.End
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))

                            CaixaDeEntrada(
                                label = stringResource(id = R.string.emailLabel),
                                placeHolder = "Ex: xxx@gmail.com",
                                value = email,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                modifier = modifierTextDefinition,
                                atualizarValor = {
                                    email = it
                                },
                                singleLine = true,
                                visualTransformation = VisualTransformation.None,
                                isError = errorEmail
                            )
                            if (errorEmail) {
                                if (email.isNullOrEmpty()) {
                                    Text(
                                        text = stringResource(id = R.string.validationEmpty),
                                        modifier = Modifier.fillMaxWidth(),
                                        fontSize = 12.sp,
                                        color = Color.Red,
                                        textAlign = TextAlign.End
                                    )
                                } else {
                                    Text(
                                        text = stringResource(id = R.string.emailValidation),
                                        modifier = Modifier.fillMaxWidth(),
                                        fontSize = 12.sp,
                                        color = Color.Red,
                                        textAlign = TextAlign.End
                                    )
                                }
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
                            if (errorSenha) {
                                if (senha.isNullOrEmpty()) {
                                    Text(
                                        text = stringResource(id = R.string.validationEmpty),
                                        modifier = Modifier.fillMaxWidth(),
                                        fontSize = 12.sp,
                                        color = Color.Red,
                                        textAlign = TextAlign.End
                                    )
                                } else {
                                    Text(
                                        text = stringResource(id = R.string.passwordValidation),
                                        modifier = Modifier.fillMaxWidth(),
                                        fontSize = 12.sp,
                                        color = Color.Red,
                                        textAlign = TextAlign.End
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))

                            CaixaDeEntrada(
                                label = stringResource(id = R.string.confirmPasswordLabel),
                                placeHolder = stringResource(id = R.string.confirmPasswordLabel),
                                value = confirmaSenha,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                modifier = modifierTextDefinition,
                                atualizarValor = {
                                    if (confirmaSenha.length <= pwdMaxLength || it.length < confirmaSenha.length) {
                                        confirmaSenha = it
                                    }
                                },
                                singleLine = true,
                                visualTransformation = PasswordVisualTransformation(),
                                isError = errorConfirmaSenha
                            )
                            if (errorConfirmaSenha) {
                                if (confirmaSenha.isNullOrEmpty()) {
                                    Text(
                                        text = stringResource(id = R.string.validationEmpty),
                                        modifier = Modifier.fillMaxWidth(),
                                        fontSize = 12.sp,
                                        color = Color.Red,
                                        textAlign = TextAlign.End
                                    )
                                } else {
                                    Text(
                                        text = stringResource(id = R.string.confirmPasswordValidation),
                                        modifier = Modifier.fillMaxWidth(),
                                        fontSize = 12.sp,
                                        color = Color.Red,
                                        textAlign = TextAlign.End
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))

                            Button(
                                onClick = {
                                    errorNomeCompleto =
                                        nomeCompleto.isNullOrEmpty() || nomeCompleto.split(" ")
                                            .count() < 2
                                    val regex = Regex("^[0-9]+$")
                                    errorCpf =
                                        cpf.isNullOrEmpty() || cpf.length < 11 || !(cpf.matches(
                                            regex
                                        ))
                                    errorEmail = email.isNullOrEmpty() || email.split("@")
                                        .count() != 2 || email.split("@")[1].split(".").count() == 0
                                    errorSenha = senha.isNullOrEmpty() || senha.length < 8
                                    errorConfirmaSenha =
                                        confirmaSenha.isNullOrEmpty() || senha != confirmaSenha

                                    if (!(errorCpf || errorEmail || errorConfirmaSenha || errorSenha || errorNomeCompleto)) {
                                        navController.navigate("login")
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
                                    text = stringResource(id = R.string.register),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 14.sp
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))
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
//fun CadastroScreenPreview() {
//    CadastroScreen()
//}