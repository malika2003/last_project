package com.example.myapplication.data.repository

import com.example.myapplication.core.BaseRepository
import com.example.myapplication.data.entity.NoteDao
import com.example.myapplication.data.mapper.NoteMapper
import com.example.myapplication.domain.model.Note
import com.example.myapplication.domain.repository.NoteRepository
import com.example.myapplication.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
): NoteRepository, BaseRepository(){

    private val noteMapper = NoteMapper()

    override fun addNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.addNotes(noteMapper.noteToNoteModel(note))
    }

    override fun getAllNotes(): Flow<Resource<List<Note>>> = doRequest {
        noteDao.getAllNotes().map { noteModel -> noteMapper.noteModelToNote(noteModel) }
    }

    override fun deleteNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.deleteNotes(noteMapper.noteToNoteModel(note))
    }

    override fun updateNote(id: Int, note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.updateNotes(noteMapper.noteToNoteModel(note))
    }


}