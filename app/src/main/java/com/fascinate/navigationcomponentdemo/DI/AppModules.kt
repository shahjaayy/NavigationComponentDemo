package com.fascinate.navigationcomponentdemo.DI

import android.content.Context
import com.fascinate.navigationcomponentdemo.Room.UsersDao
import com.fascinate.navigationcomponentdemo.Room.UsersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModules {

    @Provides
    @Singleton
    fun getUsersDatabase(context: Context): UsersDatabase
    {
        return UsersDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun getUsersDao(usersDatabase: UsersDatabase): UsersDao
    {
        return usersDatabase.userDao()
    }
}