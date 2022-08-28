package com.example.myapplication.data.entity

import androidx.room.*
import com.example.myapplication.data.model.NoteModel

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    suspend fun getAllNotes() : List<NoteModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNotes(noteModel: NoteModel)

    @Delete
    suspend fun deleteNotes(noteModel: NoteModel)

    @Update
    suspend fun updateNotes(noteModel: NoteModel)
}