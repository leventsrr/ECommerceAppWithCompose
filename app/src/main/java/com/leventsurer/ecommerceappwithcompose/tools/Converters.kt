package com.leventsurer.ecommerceappwithcompose.tools

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.Rating


class Converters {
    @TypeConverter
    fun fromRating(rating: Rating?): String? {
        return rating?.let {
            Gson().toJson(it)
        }
    }

    @TypeConverter
    fun toRating(ratingString: String?): Rating? {
        return ratingString?.let {
            Gson().fromJson(it, Rating::class.java)
        }
    }
}