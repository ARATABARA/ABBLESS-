package com.abbless.app.admin.social

data class AdminPost(
    val id: String,
    val authorName: String,
    val text: String,
    val imageUri: String? = null,
    val likes: Int = 0,
    val comments: Int = 0,
    val shares: Int = 0,
    val saved: Boolean = false,
    val pinned: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
