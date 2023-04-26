package com.arigarasuthan.viewmodelscopedemoapp

import kotlinx.coroutines.delay

class UserRepo {
    suspend fun getUsers():List<User> {
        delay(8000)
        val users:List<User> = listOf(
            User(1,"ari"),
            User(2,"hari"),
            User(3,"sam"),
            User(4,"jery"),
            User(5,"tom"),
            User(6,"hendry")
        )

        return users

    }
}