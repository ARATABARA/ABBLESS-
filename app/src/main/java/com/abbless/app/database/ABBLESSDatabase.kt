package com.abbless.app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [LessonEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ABBLESSDatabase : RoomDatabase() {

    abstract fun lessonDao(): LessonDao

    companion object {

        @Volatile
        private var INSTANCE: ABBLESSDatabase? = null

        fun getDatabase(
            context: Context
        ): ABBLESSDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ABBLESSDatabase::class.java,
                    "abbless_database"
                ).build()

                INSTANCE = instance

                instance
            }
        }
    }
}

