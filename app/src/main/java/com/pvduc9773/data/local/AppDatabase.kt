package com.pvduc9773.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pvduc9773.AppConstants
import com.pvduc9773.data.local.dao.MovieDao
import com.pvduc9773.data.model.Movie

/**
 * Created by pvduc9773 on 5/18/20.
 */
@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = buildDatabase(context)
                    }
                }
            }
            return INSTANCE
        }

        fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.DB_NAME)
                .allowMainThreadQueries()
                .build()
        }
    }

    /** @Dao */
    abstract fun movieDao(): MovieDao
}