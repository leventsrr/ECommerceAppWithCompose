package com.leventsurer.ecommerceappwithcompose.data.local.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.Rating
import kotlinx.android.parcel.Parcelize
import javax.annotation.Nonnull
@Entity(tableName = "favorite_product")
@Parcelize
data class FavoriteProductModel(
    @PrimaryKey(autoGenerate = false)
    @Nonnull
    @ColumnInfo(name = "productId")
    var productId: Int,

    @ColumnInfo(name = "productImageUrl")
    var productImageUrl: String,

    @ColumnInfo(name = "productTitle")
    var productTitle: String,

    @ColumnInfo(name = "productDescription")
    var productDescription: String,

    @ColumnInfo(name = "productPrice")
    var productPrice: String,

    @ColumnInfo(name = "productCategory")
    var productCategory: String,

    @ColumnInfo(name = "productRating")
    var productRating: Rating,
) : Parcelable
