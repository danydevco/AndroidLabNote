package com.example.parcial_2_jg.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import androidx.lifecycle.ViewModelProvider
import com.example.parcial_2_jg.R
import com.example.parcial_2_jg.ui.viewModels.NoteViewModels

class CreateNoteActivity : AppCompatActivity() {

    lateinit var inp_title:EditText
    lateinit var inp_description:MultiAutoCompleteTextView
    private lateinit var noteViewModel: NoteViewModels


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        noteViewModel= ViewModelProvider(this).get(NoteViewModels::class.java)

        inp_title=findViewById(R.id.inp_title_create)
        inp_description=findViewById(R.id.inp_contenido_create)

        findViewById<Button>(R.id.btn_save_create)
            .setOnClickListener {
                val title = inp_title.text.toString()
                val description = inp_description.text.toString()
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    noteViewModel.createNote(title, description)
                    finish()
                }
            }
    }
}