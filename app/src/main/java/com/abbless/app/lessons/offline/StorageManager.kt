package com.abbless.app.lessons.offline

object StorageManager {


    private val files =
        mutableListOf<OfflineLesson>()


    fun save(
        lesson: OfflineLesson
    ){

        files.add(lesson)

    }


    fun getDownloads():
            List<OfflineLesson>{

        return files

    }

}
