package com.abbless.app.ai.api


interface AIService {


    suspend fun askAI(
        message: String
    ): String


}
