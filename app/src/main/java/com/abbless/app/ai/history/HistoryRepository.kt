package com.abbless.app.ai.history


object HistoryRepository {


    private val messages =
        mutableListOf<MessageHistory>()


    fun save(
        history: MessageHistory
    ){

        messages.add(history)

    }


    fun getConversation(
        id: String
    ): List<MessageHistory>{


        return messages.filter {

            it.conversationId == id

        }

    }


}
