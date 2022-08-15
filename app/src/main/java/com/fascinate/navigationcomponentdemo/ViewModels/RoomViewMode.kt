package com.fascinate.navigationcomponentdemo

import android.text.TextUtils
import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.fascinate.navigationcomponentdemo.Repositories.RoomRepository
import com.fascinate.navigationcomponentdemo.Room.UsersEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import org.w3c.dom.Text
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(private val repo: RoomRepository) : ViewModel() {

    fun addUser(entity: UsersEntity) {
        repo.addUser(entity)
    }

    fun validateInformation(entity: UsersEntity, isLogin: Boolean): Pair<Boolean, String> {
        var result = Pair(true, "")
        if ((!isLogin && TextUtils.isEmpty(entity.name)) || TextUtils.isEmpty(entity.email) || TextUtils.isEmpty(
                entity.password
            )
        ) {
            result = Pair(false, "Please provide all the fields")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(entity.email).matches()) {
            result = Pair(false, "Please provide valid email")
        } else if (entity.password.length <= 5) {
            result = Pair(false, "Password must be greater than 5")
        }
        return result
    }
}