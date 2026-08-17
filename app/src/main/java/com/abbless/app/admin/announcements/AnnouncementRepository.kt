package com.abbless.app.admin.announcements

object AnnouncementRepository {

    private val announcements =
        mutableListOf<Announcement>()

    fun publish(
        announcement: Announcement
    ) {
        announcements.add(announcement)
    }

    fun getAll(): List<Announcement> {
        return announcements.toList()
    }

    fun delete(id: String) {

        announcements.removeAll {
            it.id == id
        }
    }
}
