package com.abbless.app.admin.statistics

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatisticsScreen() {

    val stats =
        StatisticsRepository.getStatistics()

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ) {

        Text(

            text = "📊 ABBLESS Statistics",

            style =
                MaterialTheme.typography.headlineMedium

        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            "👥 Total Users: ${stats.totalUsers}"
        )

        Text(
            "🟢 Active Users: ${stats.activeUsers}"
        )

        Text(
            "📚 Total Lessons: ${stats.totalLessons}"
        )

        Text(
            "✅ Completed Lessons: ${stats.completedLessons}"
        )

        Text(
            "📝 Total Quizzes: ${stats.totalQuizzes}"
        )

        Text(
            "🎯 Quiz Attempts: ${stats.quizAttempts}"
        )

        Text(
            "🤖 AI Requests: ${stats.aiRequests}"
        )

        Text(
            "💰 Revenue: ${stats.totalRevenue} BIF"
        )
    }
}
