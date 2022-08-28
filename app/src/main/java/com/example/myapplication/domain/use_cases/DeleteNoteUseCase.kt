package com.example.myapplication.domain.use_cases

import com.example.myapplication.domain.model.Note
import com.example.myapplication.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(private val repo: NoteRepository) {

    fun deleteNote(note: Note) = repo.deleteNote(note)
}