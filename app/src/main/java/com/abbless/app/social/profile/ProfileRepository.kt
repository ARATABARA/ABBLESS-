package com.abbless.app.social.profile


object ProfileRepository {


    private val profiles =
        mutableListOf<UserProfile>()


    fun saveProfile(
        profile: UserProfile
    ){

        profiles.add(profile)

    }


    fun getProfile(
        userId: String
    ): UserProfile? {


        return profiles.find {

            it.userId == userId

        }

    }


}
