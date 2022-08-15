package com.fascinate.navigationcomponentdemo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsersDao {

    @Insert
    fun signupUser(usersEntity: UsersEntity)

    @Query("SELECT * FROM UserInformation WHERE email LIKE :email AND password LIKE :password")
    fun loginUser(email: String, password: String): LiveData<LoginUser>
}