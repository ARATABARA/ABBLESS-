package com.abbless.app.social.notification


object NotificationManager {


    fun markRead(
        id: String
    ){

        // Update notification status

    }


    fun send(
        notification: Notification
    ){

        NotificationRepository.add(
            notification
        )

    }


}
