package com.abbless.app.ai.chat


import com.abbless.app.ai.assistant.AIEngine


object ChatRepository {


    fun sendMessage(
        message: String
    ): String {


        return AIEngine.answer(
            message
        )


    }


}
