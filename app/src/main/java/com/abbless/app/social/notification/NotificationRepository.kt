package com.abbless.app.social.notification


object NotificationRepository {


    private val notifications =
        mutableListOf<Notification>()


    fun add(
        notification: Notification
    ){

        notifications.add(notification)

    }


    fun getUserNotifications(
        userId: String
    ): List<Notification>{


        return notifications.filter {

            it.userId == userId

        }

    }


}
