package com.example.parcial_2_jg.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_2_jg.R
import com.example.parcial_2_jg.ui.adapters.NoteAdapter
import com.example.parcial_2_jg.ui.viewModels.NoteViewModels

class MainActivity : AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModels
    private lateinit var recyclerView: RecyclerView

    private val tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteViewModel= ViewModelProvider(this).get(NoteViewModels::class.java)
        recyclerView = findViewById(R.id.rv_list_notes)

        noteViewModel.noteList.observe(this){notes->
            Log.d(tag, "Notas: $notes")
            val adapter = NoteAdapter(notes, noteViewModel)
            recyclerView.adapter = adapter
        }

        noteViewModel.getNotes()

        findViewById<Button>(R.id.btn_add_note).setOnClickListener {
            val intent = Intent(this, CreateNoteActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        noteViewModel.getNotes()
    }
}