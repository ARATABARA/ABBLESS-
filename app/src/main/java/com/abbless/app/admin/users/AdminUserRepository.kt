package com.abbless.app.admin.users

object AdminUserRepository {

    private val users =
        mutableListOf<ManagedUser>()

    fun addUser(user: ManagedUser) {
        users.add(user)
    }

    fun getUsers(): List<ManagedUser> {
        return users.toList()
    }

    fun suspendUser(id: String) {

        val index = users.indexOfFirst {
            it.id == id
        }

        if (index != -1) {

            users[index] =
                users[index].copy(
                    active = false
                )
        }
    }

    fun activateUser(id: String) {

        val index = users.indexOfFirst {
            it.id == id
        }

        if (index != -1) {

            users[index] =
                users[index].copy(
                    active = true
                )
        }
    }

    fun deleteUser(id: String) {

        users.removeAll {
            it.id == id
        }
    }
}
