package com.leventsurer.ecommerceappwithcompose.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CustomElevatedButton(
    buttonText: String,
    onClick: () -> Unit,
    backgroundColor: Color = Color.Black,
    textColor: Color = Color.White,
    logo: Int? = null
) {
    ElevatedButton(
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        onClick = onClick
    ) {
        if (logo == null) {
            Text(
                text = buttonText,
                fontWeight = FontWeight.Bold,
                color = textColor,
                modifier = Modifier.padding(vertical = 3.dp)
            )
        } else {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = logo), contentDescription = "logo")
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = buttonText,
                    modifier = Modifier.padding(vertical = 3.dp),
                    color = textColor
                )
            }
        }
    }
}