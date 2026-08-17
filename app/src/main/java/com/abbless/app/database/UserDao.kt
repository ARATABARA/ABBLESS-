package com.abbless.app.database

import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(
        email: String
    ): UserEntity?

    @Query("DELETE FROM users WHERE id = :id")
    suspend fun deleteUser(id: String)

    @Query("""
        UPDATE users
        SET active = :active
        WHERE id = :id
    """)
    suspend fun setUserActive(
        id: String,
        active: Boolean
    )
}
