package com.example.parcial_2_jg.ui.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.parcial_2_jg.data.model.NoteModel
import com.example.parcial_2_jg.data.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModels(application: Application):AndroidViewModel(application){

    private val noteRepository = NoteRepository(application)

    private val _noteList = MutableLiveData<List<NoteModel>>()
    val noteList: MutableLiveData<List<NoteModel>>
        get() = _noteList

    fun getNotes(){
        viewModelScope.launch {
            val notes = noteRepository.getNotes()
            _noteList.value = notes
        }
    }

    fun updateNote(nid:Long, title:String, description:String){
        viewModelScope.launch {
            val note = NoteModel(nid, title, description)
            noteRepository.updateNote(note)
        }
    }

    fun deleteNote(note:NoteModel){
        viewModelScope.launch {
            noteRepository.deleteNote(note)
            getNotes()
        }
    }

    fun createNote(title:String, description:String){
        viewModelScope.launch {
            val note = NoteModel(null, title, description)
            noteRepository.insertNote(note)
        }
    }
}