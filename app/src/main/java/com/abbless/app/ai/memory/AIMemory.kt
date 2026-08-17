package com.abbless.app.ai.memory


object AIMemory {


    private val memories =
        mutableListOf<MemoryItem>()


    fun remember(
        item: MemoryItem
    ){

        memories.add(item)

    }


    fun getMemory(
        userId: String
    ): List<MemoryItem>{


        return memories.filter {

            it.userId == userId

        }

    }


}
