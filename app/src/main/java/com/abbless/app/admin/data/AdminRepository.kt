package com.abbless.app.admin.data

import com.abbless.app.admin.model.AdminUser

object AdminRepository {

    private val admins =
        mutableListOf<AdminUser>()

    fun addAdmin(
        admin: AdminUser
    ) {
        admins.add(admin)
    }

    fun isAdmin(
        userId: String
    ): Boolean {

        return admins.any {

            it.userId == userId &&
            it.isAdmin

        }
    }
}
