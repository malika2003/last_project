package com.example.myapplication.data.mapper

import com.example.myapplication.data.model.NoteModel
import com.example.myapplication.domain.model.Note

class NoteMapper {

    fun noteToNoteModel(note: Note) = NoteModel (
        id = note.id,
        title = note.title,
        description = note.desc,
        date = note.date
    )

    fun noteModelToNote(noteModel: NoteModel) = Note (
        id = noteModel.id,
        title = noteModel.title,
        desc = noteModel.description,
        date = noteModel.date
            )
}