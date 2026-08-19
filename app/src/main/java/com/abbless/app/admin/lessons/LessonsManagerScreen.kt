package com.abbless.app.admin.lessons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
private fun LessonCard(
    lesson: AdminLesson,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    androidx.compose.material3.Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("📚 ${lesson.title}")

            Spacer(modifier = Modifier.height(4.dp))

            Text("Category: ${lesson.category}")

            Spacer(modifier = Modifier.height(4.dp))

            Text("Language: ${lesson.language}")

            Spacer(modifier = Modifier.height(4.dp))

            Text(lesson.description)

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = onEdit) {
                    Text("✏️ Edit")
                }

                Button(onClick = onDelete) {
                    Text("🗑️ Delete")
                }
            }
        }
    }
}

@Composable
private fun LessonEditorDialog(
    title: String,
    initialTitle: String,
    initialCategory: String,
    initialLanguage: String,
    initialDescription: String,
    onDismiss: () -> Unit,
    onSave: (
        String,
        String,
        String,
        String
    ) -> Unit
) {
    var lessonTitle by remember {
        mutableStateOf(initialTitle)
    }

    var category by remember {
        mutableStateOf(initialCategory)
    }

    var language by remember {
        mutableStateOf(initialLanguage)
    }

    var description by remember {
        mutableStateOf(initialDescription)
    }

    AlertDialog(
        onDismissRequest = onDismiss,

        title = {
            Text(title)
        },

        text = {
            Column {
                OutlinedTextField(
                    value = lessonTitle,
                    onValueChange = {
                        lessonTitle = it
                    },
                    label = {
                        Text("Lesson title")
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                OutlinedTextField(
                    value = category,
                    onValueChange = {
                        category = it
                    },
                    label = {
                        Text("Category")
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                OutlinedTextField(
                    value = language,
                    onValueChange = {
                        language = it
                    },
                    label = {
                        Text("Language")
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                OutlinedTextField(
                    value = description,
                    onValueChange = {
                        description = it
                    },
                    label = {
                        Text("Description")
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },

        confirmButton = {
            Button(
                onClick = {
                    if (lessonTitle.isNotBlank()) {
                        onSave(
                            lessonTitle,
                            category,
                            language,
                            description
                        )
                    }
                }
            ) {
                Text("💾 Save")
            }
        },

        dismissButton = {
            Button(
                onClick = onDismiss
            ) {
                Text("Cancel")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonsManagerScreen(
    onBack: () -> Unit = {}
) {
    val lessons = remember {
        mutableStateListOf(
            AdminLesson(
                id = "1",
                title = "Science",
                description = "Lesson ya Science",
                category = "Science",
                language = "Kirundi"
            ),

            AdminLesson(
                id = "2",
                title = "Economics",
                description = "Lesson ya Economics",
                category = "Economics",
                language = "Kirundi"
            )
        )
    }

    var searchText by remember {
        mutableStateOf("")
    }

    var showAddDialog by remember {
        mutableStateOf(false)
    }

    var editingLesson by remember {
        mutableStateOf<AdminLesson?>(null)
    }

    val filteredLessons = lessons.filter {
        it.title.contains(
            searchText,
            ignoreCase = true
        ) ||
        it.category.contains(
            searchText,
            ignoreCase = true
        ) ||
        it.language.contains(
            searchText,
            ignoreCase = true
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("📚 Lessons Manager")
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            OutlinedTextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                },
                label = {
                    Text("🔎 Search lessons")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Button(
                    onClick = onBack,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("⬅️ Back")
                }

                Button(
                    onClick = {
                        showAddDialog = true
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("➕ Add")
                }
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(
                    filteredLessons,
                    key = { it.id }
                ) { lesson ->

                    LessonCard(
                        lesson = lesson,

                        onEdit = {
                            editingLesson = lesson
                        },

                        onDelete = {
                            lessons.remove(lesson)
                        }
                    )
                }
            }
        }
    }

    if (showAddDialog) {
        LessonEditorDialog(
            title = "➕ Add Lesson",
            initialTitle = "",
            initialCategory = "",
            initialLanguage = "Kirundi",
            initialDescription = "",

            onDismiss = {
                showAddDialog = false
            },

            onSave = {
                    title,
                    category,
                    language,
                    description ->

                lessons.add(
                    AdminLesson(
                        id = System.currentTimeMillis().toString(),
                        title = title,
                        description = description,
                        category = category,
                        language = language
                    )
                )

                showAddDialog = false
            }
        )
    }

    editingLesson?.let { lesson ->

        LessonEditorDialog(
            title = "✏️ Edit Lesson",
            initialTitle = lesson.title,
            initialCategory = lesson.category,
            initialLanguage = lesson.language,
            initialDescription = lesson.description,

            onDismiss = {
                editingLesson = null
            },

            onSave = {
                    title,
                    category,
                    language,
                    description ->

                val index = lessons.indexOfFirst {
                    it.id == lesson.id
                }

                if (index >= 0) {
                    lessons[index] = lesson.copy(
                        title = title,
                        category = category,
                        language = language,
                        description = description
                    )
                }

                editingLesson = null
            }
        )
    }
}
