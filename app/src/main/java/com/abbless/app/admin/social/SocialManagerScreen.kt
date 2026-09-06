package com.abbless.app.admin.social

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.UUID

@Composable
fun SocialManagerScreen(
    onBack: () -> Unit = {}
) {
    var text by remember { mutableStateOf("") }
    var refresh by remember { mutableStateOf(0) }

    val posts = remember(refresh) {
        AdminPostRepository.getPosts()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "💬 Social Manager",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Write a post") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (text.isNotBlank()) {

                    AdminPostRepository.addPost(
                        AdminPost(
                            id = UUID.randomUUID().toString(),
                            authorName = "ABBLESS Admin",
                            text = text.trim()
                        )
                    )

                    text = ""
                    refresh++
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📤 Publish Post")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Posts",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (posts.isEmpty()) {

            Text("Nta post iraboneka.")

        } else {

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                items(posts) { post ->

                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = post.authorName,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(post.text)

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                "❤️ ${post.likes}   💬 ${post.comments}   🔁 ${post.shares}"
                            )

                            if (post.pinned) {
                                Text("📌 Pinned")
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {

                                Button(
                                    onClick = {
                                        AdminPostRepository.togglePin(post.id)
                                        refresh++
                                    }
                                ) {
                                    Text(
                                        if (post.pinned)
                                            "Unpin"
                                        else
                                            "Pin"
                                    )
                                }

                                Button(
                                    onClick = {
                                        AdminPostRepository.toggleSave(post.id)
                                        refresh++
                                    }
                                ) {
                                    Text(
                                        if (post.saved)
                                            "Unsave"
                                        else
                                            "Save"
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            Button(
                                onClick = {
                                    AdminPostRepository.deletePost(post.id)
                                    refresh++
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("🗑️ Delete")
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("⬅ Back")
        }
    }
}
