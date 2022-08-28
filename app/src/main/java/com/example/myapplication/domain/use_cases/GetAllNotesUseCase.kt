package com.example.myapplication.domain.use_cases

import com.example.myapplication.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(private val repo: NoteRepository) {

    fun getAllNotes() = repo.getAllNotes()
}