package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Checkroom
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductInCartModel
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse

@Composable
fun ProductTotalPriceAndCartButton(
    totalPrice: Double,
    addProductToCart: (ProductInCartModel) -> Unit,
    productModel: GetProductResponse,
    productQuantity: Int
) {

    var isProductAdded by remember {
        mutableStateOf(false)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        Column(modifier = Modifier.padding(end = 20.dp)) {
            Text(
                text = stringResource(id = R.string.total_price),
                color = Color.LightGray,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                text = "$${String.format("%.2f", totalPrice)}",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
        ElevatedButton(
            colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.Black),
            onClick = {
                val model = ProductInCartModel(
                    productId = productModel.id,
                    productImageUrl = productModel.image,
                    productTitle = productModel.title,
                    productPrice = productModel.price,
                    productQuantity = productQuantity
                )
                addProductToCart(model)
                isProductAdded = true

            }) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if(isProductAdded){
                    Icon(imageVector = Icons.Filled.Checkroom, contentDescription = "", tint = Color.White)
                }else{
                    Image(
                        painter = painterResource(id = R.drawable.shopping_bag),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = stringResource(id = R.string.add_to_cart), color = Color.White)
                }

            }
        }
    }
}