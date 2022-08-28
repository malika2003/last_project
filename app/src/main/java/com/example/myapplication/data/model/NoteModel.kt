package com.example.myapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String? = null,
    val description : String? = null,
    val date: String? = null
)
