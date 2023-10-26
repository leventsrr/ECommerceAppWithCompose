package com.leventsurer.ecommerceappwithcompose.presentation.login_screen.view.composable

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inputs(userName:String,password:String,onUserNameValueChange:(String)->Unit,onPasswordValueChange:(String)->Unit) {
    Text(text = "Email", fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(5.dp))
    TextField(
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),

        value = userName,
        onValueChange ={
            onUserNameValueChange(it)
        } )
    Spacer(modifier = Modifier.height(20.dp))

    Text(text = "Password", fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(5.dp))
    TextField(
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent,),
        value = password,
        onValueChange ={
            onPasswordValueChange(it)

        } )
}
