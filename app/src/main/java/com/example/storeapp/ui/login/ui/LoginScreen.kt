package com.example.storeapp.ui.login.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.storeapp.R

@Preview
@Composable
fun LoginScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { Toolbar() }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            item {
                Content()
            }
        }
    }
}

@Composable
fun Content() {
    val markProFontFamily = FontFamily(
        Font(R.font.mark_pro, FontWeight.Normal)
    )
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Iniciar sesión",
            fontSize = 36.sp,
            fontFamily = markProFontFamily,
            fontWeight = FontWeight(700),
            color = colorResource(id = R.color.dark)
        )
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        EmailField()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        PasswordField()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        ButtonLogin()
    }
}

@Composable
fun ButtonLogin() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(18.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = colorResource(id = R.color.white),
            containerColor = colorResource(id = R.color.orange_app),
        )
    ) {
        Text(text = "Iniciar sesión")
    }
}

@Composable
fun EmailField() {
    Column {
        Text(
            text = "User name",
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            color = colorResource(R.color.gray)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            singleLine = true,
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.orange_app),
                unfocusedBorderColor = Color.Gray
            )
        )
    }
}

@Composable
fun PasswordField() {
    Text(
        text = "Contraseña",
        fontSize = 14.sp,
        fontWeight = FontWeight(400),
        color = colorResource(R.color.gray)
    )
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        onValueChange = {},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(R.color.orange_app),
            unfocusedBorderColor = Color.Gray
        ),
        supportingText = {
            Text(
                text = "Me olvide mi contraseña",
                color = colorResource(R.color.orange_text),
                fontSize = 12.sp
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    //val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        //colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.DarkGray),
        title = { },
        navigationIcon = {
            IconButton(onClick = { /* Acción */ }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Menú")
            }
        },
        //scrollBehavior = scrollBehavior
    )
}