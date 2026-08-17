package com.abbless.app.admin.statistics

object StatisticsRepository {

    fun getStatistics(): AdminStatistics {

        return AdminStatistics(

            totalUsers = 0,

            activeUsers = 0,

            totalLessons = 0,

            completedLessons = 0,

            totalQuizzes = 0,

            quizAttempts = 0,

            aiRequests = 0,

            totalRevenue = 0

        )
    }
}
