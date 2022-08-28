package com.example.myapplication.domain.model

data class Note(
    val id : Int = DEFAULT_ID,
    val title: String? = null,
    val desc: String? = null,
    val date: String? = null
) {
    companion object {
        const val DEFAULT_ID = 0
    }
}
