package com.leventsurer.ecommerceappwithcompose.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [ProductModel::class], version = 1)
abstract class ProductRoomDatabase :RoomDatabase(){
    abstract fun productDao(): ProductDao

}


