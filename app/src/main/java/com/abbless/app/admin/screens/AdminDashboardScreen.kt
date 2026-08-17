import com.abbless.app.admin.auth.AdminSession Bu
tton(onClick = {}) {
    Text("🔐 Security")
}

Button(onClick = {}) {
    Text("📚 Lessons Manager")
}

Button(onClick = {}) {
    Text("👥 Users Manager")
}

Button(onClick = {}) {
    Text("💬 Social Manager")
}

Button(onClick = {}) {
    Text("🤖 AI Manager")
}

Button(onClick = {}) {
    Text("📢 Announcements")
}

Button(onClick = {}) {
    Text("💳 Payments & Prices")
}

Button(onClick = {}) {
    Text("🎟️ Activation Codes")
}

Button(onClick = {}) {
    Text("📊 Statistics")
}

Button(onClick = {}) {
    Text("🌍 Languages")
}

Button(onClick = {}) {
    Text("💾 Backup & Database")
}

Button(onClick = {}) {
    Text("⚙️ App Settings")
}

onLogoutClick: () -> Unit = {}
}

Spacer(
    modifier = Modifier.height(20.dp)
)

Button(
    onClick = onLogoutClick,
    modifier = Modifier.fillMaxWidth()
) {
    Text("🚪 Logout")
}

onLogoutClick = {

    AdminSession.logout()

    navController.navigate("admin_login") {

        popUpTo("admin_dashboard") {
            inclusive = true
        }
    }
},
