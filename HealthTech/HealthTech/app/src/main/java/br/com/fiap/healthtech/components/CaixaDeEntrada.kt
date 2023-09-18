package br.com.fiap.healthtech.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import br.com.fiap.healthtech.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeEntrada(
    label: String,
    placeHolder: String,
    value: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier,
    atualizarValor: (String) -> Unit,
    singleLine: Boolean,
    visualTransformation: VisualTransformation,
    isError: Boolean
) {
    OutlinedTextField(
        value = value,
        onValueChange = atualizarValor,
        modifier = modifier,
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeHolder)
        },
        keyboardOptions = keyboardOptions,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = colorResource(id = R.color.azul_4_ht),
            focusedBorderColor = colorResource(id = R.color.azul_4_ht),
            focusedLabelColor = colorResource(id = R.color.azul_4_ht)
        ),
        shape = RoundedCornerShape(16.dp),
        singleLine = singleLine,
        visualTransformation = visualTransformation,
        isError = isError
    )
}