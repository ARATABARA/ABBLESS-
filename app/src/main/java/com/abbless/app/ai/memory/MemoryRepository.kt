package com.abbless.app.ai.memory


object MemoryRepository {


    fun save(
        memory: MemoryItem
    ){

        AIMemory.remember(
            memory
        )

    }


    fun load(
        userId: String
    ): List<MemoryItem>{

        return AIMemory.getMemory(
            userId
        )

    }


}
