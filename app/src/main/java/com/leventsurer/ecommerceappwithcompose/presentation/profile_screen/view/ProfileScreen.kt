package com.leventsurer.ecommerceappwithcompose.presentation.profile_screen.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.profile_screen.view.composable.GeneralAppSettings
import com.leventsurer.ecommerceappwithcompose.presentation.profile_screen.view.composable.UserSection
import com.leventsurer.ecommerceappwithcompose.presentation.profile_screen.view.composable.UserSectionRow

@Composable
fun ProfileScreen(
    paddingValues: PaddingValues
) {

    val userSectionRowItemIcons = arrayListOf(
        Icons.Filled.AccountCircle,
        Icons.Filled.ShoppingBag,
        Icons.Filled.Favorite,
        Icons.Filled.LocalShipping,
        Icons.Filled.CreditCard,
        Icons.Filled.Settings
    )

    val userSectionRowItemTitle = arrayListOf(
        "Personal Details",
        "My Order",
        "My Favorites",
        "Shipping Address",
        "My Card",
        "Settings"
    )

    val generalAppSectionRowItemIcons = arrayListOf(Icons.Default.Warning,Icons.Filled.PrivacyTip)

    val generalAppSectionRowItemTitles = arrayListOf("FAQs","Privacy Policy")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(
                start = 10.dp,
                end = 10.dp,
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.model1),
                    contentDescription = "",
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                        .padding(vertical = 10.dp)
                )
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Fscreation", fontWeight = FontWeight.ExtraBold, fontSize = 24.sp)
                    Text(
                        text = "Fscreation441@gmail.com",
                        fontWeight = FontWeight.Bold,
                        color = Color.LightGray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        UserSection(userSectionRowItemIcons,userSectionRowItemTitle)
        Spacer(modifier = Modifier.height(30.dp))
        GeneralAppSettings(generalAppSectionRowItemIcons,generalAppSectionRowItemTitles)
    }
}

