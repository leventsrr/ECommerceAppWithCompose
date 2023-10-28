package com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view

import android.widget.GridLayout
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.common.GreetingsTexts
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable.HomePageProductCard
import com.leventsurer.ecommerceappwithcompose.ui.theme.Gray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navigateToCategoriesPage: () -> Unit,
    onProductDetailClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 10.dp,
                end = 10.dp,
                top = paddingValues.calculateTopPadding()
            )
            .verticalScroll(rememberScrollState())
    ) {
        GreetingsTexts(title = "Welcome,", text = "Our Fashions App")

        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(4f),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.LightGray.copy(0.3f),
                    unfocusedBorderColor = Color.Transparent
                ),
                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
                label = { Text(text = "Search...", color = Color.Gray) },
                shape = CircleShape,
                value = "",
                onValueChange = {},
            )
            Spacer(modifier = Modifier.width(20.dp))
            FloatingActionButton(
                containerColor = Color.Black,
                modifier = Modifier.size(32.dp),
                shape = CircleShape,
                onClick = navigateToCategoriesPage
            ) {
                Icon(imageVector = Icons.Default.FilterAlt, contentDescription = "", tint = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.onboarding3),
                        contentDescription = ""
                    )
                    Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                        Text(text = "Axel Arigato", fontWeight = FontWeight.Bold)
                        Text(
                            text = "Clean 90 Triple Sceakers",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                        Text(text = "$245.00", fontWeight = FontWeight.Bold)
                    }
                }
                ElevatedButton(
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp),
                    contentPadding = PaddingValues(horizontal = 0.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = RoundedCornerShape(10),
                    onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.padding(horizontal = 5.dp)) {
            Text(text = "Top Categories", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                for (i in 0..3) {
                    Card(
                        border = BorderStroke(1.dp, Color.LightGray),
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier
                            .width(90.dp)
                            .padding(horizontal = 3.dp)
                    ) {
                        Text(
                            text = "Kışlık",
                            color = Color.Black,
                            modifier = Modifier
                                .padding(horizontal = 10.dp, vertical = 10.dp)
                                .fillMaxWidth(),
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.padding(horizontal = 5.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "New Arrivals", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "View All", fontWeight = FontWeight.Bold, fontSize = 13.sp)
            }
            for (i in 0..2) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    HomePageProductCard(onProductDetailClick = onProductDetailClick)
                    HomePageProductCard(onProductDetailClick = onProductDetailClick)
                }
            }
        }

    }


}