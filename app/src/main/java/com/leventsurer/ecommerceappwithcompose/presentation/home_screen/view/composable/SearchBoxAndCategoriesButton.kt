package com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBoxAndCategoriesButton(
    searchingProductName: String,
    typeSearchingProductName: (String) -> Unit,
    navigateToCategoriesPage: () -> Unit,
    searchProduct: (String) -> Unit,
    cancelSearch: () -> Unit
) {
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
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Black
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        searchProduct(searchingProductName)
                    })
            },
            trailingIcon = {
                if (!searchingProductName.isNullOrEmpty()) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            cancelSearch()
                        })
                }
            },
            placeholder = { Text(text = "Search...", color = Color.Gray) },
            shape = CircleShape,
            value = searchingProductName,
            onValueChange = {
                typeSearchingProductName(it)
            },
        )
        Spacer(modifier = Modifier.width(20.dp))

        if(searchingProductName.isNullOrEmpty()){
            OutlinedIconButton(
                modifier = Modifier.size(35.dp),
                colors = IconButtonDefaults.outlinedIconButtonColors(containerColor = Color.Black),
                onClick = navigateToCategoriesPage
            ) {
                Icon(
                    imageVector = Icons.Default.FilterAlt,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    }
}