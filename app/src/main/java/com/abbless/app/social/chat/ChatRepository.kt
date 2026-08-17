package com.abbless.app.social.chat


import com.abbless.app.social.model.Message


object ChatRepository {


    private val messages =
        mutableListOf<Message>()


    fun sendMessage(
        message: Message
    ){

        messages.add(message)

    }


    fun getMessages(
        userId: String
    ): List<Message>{


        return messages.filter {

            it.senderId == userId ||
            it.receiverId == userId

        }

    }


}
