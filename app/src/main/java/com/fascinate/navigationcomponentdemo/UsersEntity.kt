package com.fascinate.navigationcomponentdemo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserInformation")
data class UsersEntity(
    val name: String,
    @PrimaryKey
    val email: String,
    val password: String
)
