package com.abbless.app.social.friends


data class FriendRequest(

    val id: String,

    val senderId: String,

    val receiverId: String,

    val time: Long

)
