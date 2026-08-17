package com.abbless.app.auth.data


import com.abbless.app.auth.model.UserAccount


object AuthRepository {


    private val users =
        mutableListOf<UserAccount>()


    fun register(
        user: UserAccount
    ){

        users.add(user)

    }


    fun login(
        email: String,
        password: String
    ): UserAccount? {


        return users.find {

            it.email == email &&
            it.password == password

        }

    }


}
