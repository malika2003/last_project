package com.example.myapplication.domain.use_cases

import com.example.myapplication.domain.model.Note
import com.example.myapplication.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(private val repo: NoteRepository) {

    fun addNote(note: Note)= repo.addNote(note)
}