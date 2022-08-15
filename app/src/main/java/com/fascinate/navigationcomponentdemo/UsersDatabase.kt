package com.fascinate.navigationcomponentdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [UsersEntity::class], version = 1)
abstract class UsersDatabase: RoomDatabase() {

    abstract fun userDao(): UsersDao

    //User Singleton pattern for managing one instance
    companion object {

        //If the instance is assigned, @volatile tell every thread that it is assigned and not null
        @Volatile
        private var INSTANCE: UsersDatabase? = null

        fun getDatabase(context: Context): UsersDatabase {
            if (INSTANCE == null)

            //Use locking to make it thread safe
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        UsersDatabase::class.java,
                        "MyNotesDB"
                    ).fallbackToDestructiveMigration().build()
                }
            return INSTANCE!!
        }
    }
}