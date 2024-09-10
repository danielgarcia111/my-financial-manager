package com.example.myfinancialmanager.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfinancialmanager.R


@Composable
fun BackGroundScreen(){

    Surface (
        //color = Color.Green,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .padding(28.dp)
    ){

        Column (
            modifier = Modifier.fillMaxSize()
        ){
            TextForm(value = stringResource(id = R.string.despesa_cartao))
            TextForm(value = stringResource(id = R.string.despesa_cartao))
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldForm(labelValue = stringResource(id = R.string.descricao))
            TextFieldForm(labelValue = stringResource(id = R.string.categoria))
            TextFieldForm(labelValue = stringResource(id = R.string.selecionar_cartao))
            TextFieldForm(labelValue = stringResource(id = R.string.valor))
            Spacer(modifier = Modifier.height(20.dp))
            ButtonComponent(value = stringResource(id = R.string.confirmar))
        }

    }
}

@Preview
@Composable
fun DefaultPreviewScreen(){
    BackGroundScreen()
}