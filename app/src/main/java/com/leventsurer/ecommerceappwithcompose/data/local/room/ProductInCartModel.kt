package com.leventsurer.ecommerceappwithcompose.data.local.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.Rating
import kotlinx.android.parcel.Parcelize
import javax.annotation.Nonnull




@Entity(tableName = "product_in_cart")
@Parcelize
data class ProductInCartModel(
    @PrimaryKey(autoGenerate = false)
    @Nonnull
    @ColumnInfo(name = "productId")
    var productId: Int,

    @ColumnInfo(name = "productImageUrl")
    var productImageUrl: String,

    @ColumnInfo(name = "productTitle")
    var productTitle: String,

    @ColumnInfo(name = "productPrice")
    var productPrice: String,

    @ColumnInfo(name = "productQuantity")
    var productQuantity: Int,

    ) : Parcelable
