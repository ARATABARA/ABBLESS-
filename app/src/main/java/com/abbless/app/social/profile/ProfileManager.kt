package com.abbless.app.social.profile


object ProfileManager {


    fun updateProfile(
        profile: UserProfile
    ){

        ProfileRepository.saveProfile(
            profile
        )

    }


    fun createDefaultProfile(
        userId: String
    ): UserProfile {


        return UserProfile(

            userId = userId,

            name = "New User",

            username = "user",

            bio = "Welcome to ABBLESS",

            level = "Beginner",

            subscription = "Free"

        )

    }


}
