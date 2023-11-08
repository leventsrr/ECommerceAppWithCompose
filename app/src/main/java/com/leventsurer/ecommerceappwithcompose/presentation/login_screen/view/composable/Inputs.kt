package com.leventsurer.ecommerceappwithcompose.presentation.login_screen.view.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.leventsurer.ecommerceappwithcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inputs(
    userName: String,
    password: String,
    onUserNameValueChange: (String) -> Unit,
    onPasswordValueChange: (String) -> Unit
) {
    Text(
        text = stringResource(id = R.string.email),
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(5.dp))
    TextField(
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),

        value = userName,
        onValueChange = {
            onUserNameValueChange(it)
        })
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = stringResource(id = R.string.password),
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(5.dp))
    TextField(
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
        value = password,
        onValueChange = {
            onPasswordValueChange(it)
        })
}
