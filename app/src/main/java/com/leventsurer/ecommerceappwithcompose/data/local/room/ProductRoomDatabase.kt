package com.leventsurer.ecommerceappwithcompose.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.leventsurer.ecommerceappwithcompose.data.di.ApplicationScope
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [ProductModel::class], version = 1)
abstract class ProductRoomDatabase :RoomDatabase(){
    abstract fun productDao(): ProductDao

    class CallBack @Inject constructor(
        private val database: Provider<ProductRoomDatabase>
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val dao = database.get().productDao()
        }
    }


}




