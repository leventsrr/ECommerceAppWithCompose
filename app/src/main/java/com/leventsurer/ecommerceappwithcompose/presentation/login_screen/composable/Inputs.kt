package com.leventsurer.ecommerceappwithcompose.presentation.login_screen.composable

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
fun Inputs() {
    Text(text = "Email", fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(5.dp))
    TextField(
        modifier = Modifier.height(20.dp).fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),

        value = "",
        onValueChange ={} )
    Spacer(modifier = Modifier.height(20.dp))

    Text(text = "Password", fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(5.dp))
    TextField(
        modifier = Modifier.height(20.dp).fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent,),
        value = "",
        onValueChange ={} )
}
