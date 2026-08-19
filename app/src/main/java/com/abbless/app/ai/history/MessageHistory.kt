package com.abbless.app.ai.history

data class MessageHistory(
    val conversationId: String,
    val message: String,
    val isUser: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)
