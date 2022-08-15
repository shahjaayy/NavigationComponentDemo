package com.fascinate.navigationcomponentdemo.Repositories

import com.fascinate.navigationcomponentdemo.Room.UsersDao
import com.fascinate.navigationcomponentdemo.Room.UsersEntity
import javax.inject.Inject

class RoomRepository @Inject constructor(private val dao: UsersDao) {

    fun addUser(usersEntity: UsersEntity) {
        usersEntity.let {
            dao.signupUser(
                usersEntity
            )
        }
    }
}