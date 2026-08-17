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
import androidx.compose.material3.Card
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

data class AdminLesson(
    val id: Long,
    var title: String,
    var category: String,
    var description: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonsManagerScreen(
    onBack: () -> Unit = {}
) {

    val lessons = remember {

        mutableStateListOf(

            AdminLesson(
                1,
                "Science",
                "Science",
                "Lesson ya Science"
            ),

            AdminLesson(
                2,
                "Economics",
                "Economics",
                "Lesson ya Economics"
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
                    Text("🔎 Search lesson")
                },

                modifier =
                    Modifier.fillMaxWidth()
            )

            Spacer(
                modifier =
                    Modifier.height(12.dp)
            )

            Button(

                onClick = {
                    showAddDialog = true
                },

                modifier =
                    Modifier.fillMaxWidth()
            ) {

                Text("➕ Add Lesson")
            }

            Spacer(
                modifier =
                    Modifier.height(12.dp)
            )

            val filteredLessons =
                lessons.filter {

                    it.title.contains(
                        searchText,
                        ignoreCase = true
                    ) ||

                    it.category.contains(
                        searchText,
                        ignoreCase = true
                    )
                }

            LazyColumn(

                verticalArrangement =
                    Arrangement.spacedBy(10.dp)

            ) {

                items(
                    filteredLessons,
                    key = {
                        it.id
                    }
                ) { lesson ->

                    LessonCard(

                        lesson = lesson,

                        onEdit = {
                            editingLesson = lesson
                        },

                        onDelete = {

                            lessons.remove(
                                lesson
                            )
                        }
                    )
                }
            }
        }
    }

    if (showAddDialog) {

        LessonEditorDialog(

            title = "Add Lesson",

            initialTitle = "",

            initialCategory = "",

            initialDescription = "",

            onDismiss = {
                showAddDialog = false
            },

            onSave = {
                title,
                category,
                description ->

                val newId =
                    (
                        lessons.maxOfOrNull {
                            it.id
                        } ?: 0
                    ) + 1

                lessons.add(

                    AdminLesson(
                        id = newId,
                        title = title,
                        category = category,
                        description = description
                    )
                )

                showAddDialog = false
            }
        )
    }

    editingLesson?.let { lesson ->

        LessonEditorDialog(

            title = "Edit Lesson",

            initialTitle =
                lesson.title,

            initialCategory =
                lesson.category,

            initialDescription =
                lesson.description,

            onDismiss = {
                editingLesson = null
            },

            onSave = {
                title,
                category,
                description ->

                lesson.title =
                    title

                lesson.category =
                    category

                lesson.description =
                    description

                editingLesson = null
            }
        )
    }
}

@Composable
private fun LessonCard(

    lesson: AdminLesson,

    onEdit: () -> Unit,

    onDelete: () -> Unit

) {

    Card(
        modifier =
            Modifier.fillMaxWidth()
    ) {

        Column(
            modifier =
                Modifier.padding(16.dp)
        ) {

            Text(
                text =
                    "📚 ${lesson.title}"
            )

            Spacer(
                modifier =
                    Modifier.height(4.dp)
            )

            Text(
                text =
                    "Category: ${lesson.category}"
            )

            Spacer(
                modifier =
                    Modifier.height(4.dp)
            )

            Text(
                text =
                    lesson.description
            )

            Spacer(
                modifier =
                    Modifier.height(10.dp)
            )

            Row(
                horizontalArrangement =
                    Arrangement.spacedBy(8.dp)
            ) {

                Button(
                    onClick = onEdit
                ) {

                    Text("✏️ Edit")
                }

                Button(
                    onClick = onDelete
                ) {

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

    initialDescription: String,

    onDismiss: () -> Unit,

    onSave:
        (
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

    var description by remember {
        mutableStateOf(
            initialDescription
        )
    }

    AlertDialog(

        onDismissRequest =
            onDismiss,

        title = {
            Text(title)
        },

        text = {

            Column {

                OutlinedTextField(

                    value =
                        lessonTitle,

                    onValueChange = {
                        lessonTitle = it
                    },

                    label = {
                        Text("Lesson title")
                    }
                )

                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )

                OutlinedTextField(

                    value =
                        category,

                    onValueChange = {
                        category = it
                    },

                    label = {
                        Text("Category")
                    }
                )

                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )

                OutlinedTextField(

                    value =
                        description,

                    onValueChange = {
                        description = it
                    },

                    label = {
                        Text("Description")
                    }
                )
            }
        },

        confirmButton = {

            Button(

                onClick = {

                    if (
                        lessonTitle
                            .isNotBlank()
                    ) {

                        onSave(
                            lessonTitle,
                            category,
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
                onClick =
                    onDismiss
            ) {

                Text("Cancel")
            }
        }
    )
}

