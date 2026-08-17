package com.abbless.app.social.friends


object FriendsRepository {


    private val requests =
        mutableListOf<FriendRequest>()


    fun sendRequest(
        request: FriendRequest
    ){

        requests.add(request)

    }


    fun getRequests(
        userId: String
    ): List<FriendRequest>{

        return requests.filter {

            it.receiverId == userId

        }

    }

}
