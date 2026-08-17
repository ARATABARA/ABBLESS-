package com.abbless.app.lessons.offline


object DownloadManager {


    fun download(
        lesson: OfflineLesson
    ){

        StorageManager.save(
            lesson.copy(
                downloaded = true
            )
        )

    }

}
