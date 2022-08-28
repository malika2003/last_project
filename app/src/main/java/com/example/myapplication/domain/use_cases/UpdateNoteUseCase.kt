package com.example.myapplication.domain.use_cases

import com.example.myapplication.domain.model.Note
import com.example.myapplication.domain.repository.NoteRepository
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(private val repo: NoteRepository) {

    fun updateNote(id: Int, note: Note) = repo.updateNote(id, note)
}