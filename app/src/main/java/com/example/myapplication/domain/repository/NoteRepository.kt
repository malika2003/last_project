package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.Note
import com.example.myapplication.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun addNote(note: Note) : Flow<Resource<Unit>>

    fun getAllNotes() : Flow<Resource<List<Note>>>

    fun deleteNote(note: Note) : Flow<Resource<Unit>>

    fun updateNote(id : Int, note: Note): Flow<Resource<Unit>>

}