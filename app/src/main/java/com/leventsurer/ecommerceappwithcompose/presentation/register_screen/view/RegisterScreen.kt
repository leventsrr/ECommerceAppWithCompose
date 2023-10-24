package com.leventsurer.ecommerceappwithcompose.presentation.register_screen.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.common.CustomElevatedButton
import com.leventsurer.ecommerceappwithcompose.presentation.common.GreetingsTexts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    padding: PaddingValues,
    onLoginClick:()->Unit
    ) {

    var string by remember {
        mutableStateOf("")
    }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(padding.calculateTopPadding()), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Image(painter =  painterResource(id = R.drawable.logo), contentDescription ="logo")
        Spacer(modifier = Modifier.height(60.dp))
        GreetingsTexts(title = "Sign Up", text ="Create an new account" )
        Spacer(modifier = Modifier.height(25.dp))
        Text(text = "User Name", fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(5.dp))
        TextField(

            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent,),
            value = "",
            onValueChange ={} )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Email", fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(5.dp))
        TextField(

            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent,),
            value = "",
            onValueChange ={} )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Password", fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(5.dp))
        TextField(

            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent,),
            value = "",
            onValueChange ={} )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Confirm Password", fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent,),
            value = string,
            onValueChange ={
                           string = it
            },
            trailingIcon = { IconButton(onClick = {
                isPasswordVisible = !isPasswordVisible
            }) {
                Icon(imageVector = if(isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff, contentDescription = "")
            }}
            )
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Checkbox(checked = false, onCheckedChange ={} )
            Text(text = "By creating an account you have to agree with our them & condication.",  color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(20.dp))
        CustomElevatedButton(buttonText = "Login", onClick = onLoginClick)
    }
}