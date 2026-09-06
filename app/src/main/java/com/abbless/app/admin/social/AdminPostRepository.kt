package com.abbless.app.admin.social

object AdminPostRepository {

    private val posts = mutableListOf<AdminPost>()

    fun getPosts(): List<AdminPost> {
        return posts.toList()
    }

    fun addPost(post: AdminPost) {
        posts.add(0, post)
    }

    fun updatePost(post: AdminPost) {
        val index = posts.indexOfFirst { it.id == post.id }

        if (index != -1) {
            posts[index] = post
        }
    }

    fun deletePost(postId: String) {
        posts.removeAll { it.id == postId }
    }

    fun togglePin(postId: String) {
        val index = posts.indexOfFirst { it.id == postId }

        if (index != -1) {
            val post = posts[index]
            posts[index] = post.copy(
                pinned = !post.pinned
            )
        }
    }

    fun toggleSave(postId: String) {
        val index = posts.indexOfFirst { it.id == postId }

        if (index != -1) {
            val post = posts[index]
            posts[index] = post.copy(
                saved = !post.saved
            )
        }
    }
}
