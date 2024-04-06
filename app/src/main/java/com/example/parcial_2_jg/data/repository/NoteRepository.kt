package com.example.parcial_2_jg.data.repository

import android.content.Context
import com.example.parcial_2_jg.data.db.AppDataBase
import com.example.parcial_2_jg.data.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteRepository (context: Context) {
    private val database=AppDataBase.getInstance(context)

    suspend fun getNotes():List<NoteModel>{
        return withContext(Dispatchers.IO){
            database.noteDao().getListNotes()
        }
    }

    suspend fun insertNote(note:NoteModel){
        withContext(Dispatchers.IO){
            database.noteDao().insertNote(note)
        }
    }

    suspend fun deleteNote(note:NoteModel){
        withContext(Dispatchers.IO){
            database.noteDao().deleteNote(note)
        }
    }

    suspend fun updateNote(note:NoteModel){
        withContext(Dispatchers.IO){
            database.noteDao().updateNote(note)
        }
    }
}