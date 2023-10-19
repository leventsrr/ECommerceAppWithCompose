@file:OptIn(ExperimentalMaterial3Api::class)

package com.leventsurer.ecommerceappwithcompose.presentation.on_boarding_screen.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.on_boarding_screen.view.composable.OnBoardingPager

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OnBoardingScreen(
    navigateToRegister:()->Unit

) {
    var pageIndex by remember {
        mutableIntStateOf(0)
    }

    val imageList =
        arrayListOf(R.drawable.onboarding1, R.drawable.onboarding2, R.drawable.onboarding3)
    val descriptionList = arrayListOf(
        " Publish up your selfies to make yourself more beautiful with this app.",
        "Discover Your Own Beauty.",
        "Fashion: More than Just Clothing."
    )
    val titleList = arrayListOf(
        "20% Discount New Arrival Product",
        "Weekend Wardrobe Revamp: Save Big on Stylish Picks!",
        "Sunday Style Savings: Big Discounts on Stylish Choices!"
    )
    Scaffold(
        content = {

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding())
            ) {
                OnBoardingPager(
                    imageList[pageIndex],
                    descriptionList[pageIndex],
                    titleList[pageIndex]
                )

                Row(
                    modifier = Modifier
                        .padding(bottom = 25.dp, start = 20.dp)

                        .height(140.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in 0 until  imageList.size) {
                        Box(
                            modifier = Modifier
                                .width(10.dp)
                                .aspectRatio(if (i == pageIndex) 3f else 1f)
                                .background(if (i == pageIndex) Color.Black else Color.LightGray, shape = CircleShape),
                            )
                        Spacer(modifier = Modifier.width(8.dp))
                    }

                }
            }


        },
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                containerColor = Color.Black,
                contentColor = Color.White,
                onClick = {
                    if (pageIndex <= imageList.size-2) {
                        Log.e("kontrol","index:${pageIndex}")
                        Log.e("kontrol","image size:${imageList.size-1}")
                        pageIndex+=1
                        Log.e("kontrol","index after:${pageIndex}")
                    }else{
                        navigateToRegister()
                    }
                }) {
                Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Next pager")
            }
        },
    )


}