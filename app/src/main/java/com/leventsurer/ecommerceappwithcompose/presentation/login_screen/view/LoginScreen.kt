package com.leventsurer.ecommerceappwithcompose.presentation.login_screen.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.common.GreetingsTexts
import com.leventsurer.ecommerceappwithcompose.presentation.login_screen.LoginViewModel
import com.leventsurer.ecommerceappwithcompose.presentation.login_screen.view.composable.Buttons
import com.leventsurer.ecommerceappwithcompose.presentation.login_screen.view.composable.Inputs

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    padding: PaddingValues,
    navigateToHomePage: () -> Unit,
) {
    val loginViewModelState = loginViewModel.loginState.value
    var userName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isCircularProgressActive by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current

    if (loginViewModelState.isLoading) {
        isCircularProgressActive = true
    } else if (loginViewModelState.result != null) {
        LaunchedEffect(Unit) {
            navigateToHomePage()
        }
        isCircularProgressActive = false
    } else if (loginViewModelState.error != null) {
        LaunchedEffect(Unit) {
            isCircularProgressActive = false
            Toast.makeText(context, "Wrong UserName Or Password", Toast.LENGTH_SHORT).show()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding.calculateTopPadding()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
        Spacer(modifier = Modifier.height(50.dp))
        GreetingsTexts(
            stringResource(id = R.string.welcome),
            stringResource(id = R.string.please_login_or_register)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Inputs(
            userName,
            password,
            onUserNameValueChange = { userName = it },
            onPasswordValueChange = { password = it })
        Spacer(modifier = Modifier.height(25.dp))
        if (isCircularProgressActive) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Color.Black)
            }
        } else {
            Buttons(userName, password, loginViewModel)
        }
    }
}



