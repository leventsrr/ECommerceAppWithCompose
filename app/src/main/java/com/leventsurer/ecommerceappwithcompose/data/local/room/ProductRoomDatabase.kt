package com.leventsurer.ecommerceappwithcompose.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.leventsurer.ecommerceappwithcompose.tools.Converters
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [FavoriteProductModel::class, ProductInCartModel::class], version = 2)
@TypeConverters(Converters::class)
abstract class ProductRoomDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    class CallBack @Inject constructor(
        private val database: Provider<ProductRoomDatabase>
    ) : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            database.get().productDao()
        }
    }
}




