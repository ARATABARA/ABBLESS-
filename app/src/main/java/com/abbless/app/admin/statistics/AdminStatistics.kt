package com.abbless.app.admin.statistics

data class AdminStatistics(

    val totalUsers: Int,

    val activeUsers: Int,

    val totalLessons: Int,

    val completedLessons: Int,

    val totalQuizzes: Int,

    val quizAttempts: Int,

    val aiRequests: Int,

    val totalRevenue: Long

)
