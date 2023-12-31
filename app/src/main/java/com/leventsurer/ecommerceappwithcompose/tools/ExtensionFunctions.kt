package com.leventsurer.ecommerceappwithcompose.tools

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun String.toFormattedDate(dateFormat:String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    val outputFormat = SimpleDateFormat(dateFormat)
    val date = inputFormat.parse(this)
    return outputFormat.format(date)
}



