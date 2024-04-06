package com.example.parcial_2_jg.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.parcial_2_jg.data.model.NoteModel

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getListNotes(): List<NoteModel>

    @Insert
    fun insertNote(note: NoteModel)

    @Delete
    fun deleteNote(note: NoteModel)

    @Update
    fun updateNote(note: NoteModel)
}