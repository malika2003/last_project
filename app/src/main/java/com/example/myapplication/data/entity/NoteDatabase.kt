package com.example.myapplication.data.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}