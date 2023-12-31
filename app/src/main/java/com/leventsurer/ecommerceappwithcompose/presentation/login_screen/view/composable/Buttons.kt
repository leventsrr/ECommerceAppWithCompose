package com.leventsurer.ecommerceappwithcompose.presentation.login_screen.view.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.request.LoginRequest
import com.leventsurer.ecommerceappwithcompose.presentation.common.CustomElevatedButton
import com.leventsurer.ecommerceappwithcompose.presentation.login_screen.LoginEvent
import com.leventsurer.ecommerceappwithcompose.presentation.login_screen.LoginViewModel
import com.leventsurer.ecommerceappwithcompose.ui.theme.FacebookThemeColor

@Composable
fun Buttons(
    userName: String,
    password: String,
    loginViewModel: LoginViewModel
) {
    CustomElevatedButton(stringResource(id = R.string.login),
        {
            loginViewModel.loginOnEvent(
                LoginEvent.Login(
                    loginRequest = LoginRequest(
                        username = userName,
                        password = password
                    )
                )
            )
        }
    )
    Spacer(modifier = Modifier.height(5.dp))
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(id = R.string.or),
            modifier = Modifier.padding(horizontal = 3.dp)
        )
        Divider(modifier = Modifier.weight(1f))
    }
    Spacer(modifier = Modifier.height(5.dp))
    CustomElevatedButton(
        stringResource(id = R.string.continue_with_facebook),
        {},
        FacebookThemeColor,
        Color.White,
        R.drawable.facebook_icon
    )
    Spacer(modifier = Modifier.height(5.dp))
    CustomElevatedButton(
        stringResource(id = R.string.continue_with_google),
        {},
        Color.White,
        Color.Gray,
        R.drawable.google_icon
    )
    Spacer(modifier = Modifier.height(5.dp))
    CustomElevatedButton(
        stringResource(id = R.string.continue_with_apple),
        onClick = {},
        backgroundColor = Color.White,
        textColor = Color.Gray,
        logo = R.drawable.apple_icon
    )
}
