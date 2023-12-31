package com.leventsurer.ecommerceappwithcompose.presentation.on_boarding_screen.view

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.on_boarding_screen.view.composable.OnBoardingPager

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OnBoardingScreen(
    navigateToRegister: () -> Unit
) {
    var pageIndex by remember {
        mutableIntStateOf(0)
    }
    val imageList =
        arrayListOf(R.drawable.onboarding1, R.drawable.onboarding2, R.drawable.onboarding3)
    val descriptionList =
        LocalContext.current.resources.getStringArray(R.array.on_boarding_descriptions)

    val titleList =  LocalContext.current.resources.getStringArray(R.array.on_boarding_titles)
    val pagerState = rememberPagerState(pageCount = {
        descriptionList.size
    })

    Scaffold(
        content = {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding())
            ) {
                HorizontalPager(
                    modifier = Modifier.weight(7f),
                    state = pagerState
                ) { index ->
                    OnBoardingPager(
                        image = imageList[index],
                        title = titleList[index],
                        description = descriptionList[index]
                    )
                    pageIndex = pagerState.currentPage
                }
                Row(
                    modifier = Modifier
                        .padding(bottom = 25.dp, start = 20.dp)
                        .height(140.dp)
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in 0 until imageList.size) {
                        Box(
                            modifier = Modifier
                                .width(10.dp)
                                .aspectRatio(if (i == pageIndex) 3f else 1f)
                                .background(
                                    if (i == pageIndex) Color.Black else Color.LightGray,
                                    shape = CircleShape
                                ),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        },
        floatingActionButton = {
            if (pageIndex > imageList.size - 2) {
                FloatingActionButton(
                    shape = CircleShape,
                    containerColor = Color.Black,
                    contentColor = Color.White,
                    onClick = {
                        navigateToRegister()
                    }) {
                    Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Next pager")
                }
            }
        },
    )
}