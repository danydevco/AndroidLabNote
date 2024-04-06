package com.example.parcial_2_jg.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import androidx.lifecycle.ViewModelProvider
import com.example.parcial_2_jg.R
import com.example.parcial_2_jg.ui.viewModels.NoteViewModels

class EditNoteActivity : AppCompatActivity() {

    lateinit var inp_title: EditText
    lateinit var inp_content: MultiAutoCompleteTextView
    private lateinit var noteViewModel: NoteViewModels

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        noteViewModel= ViewModelProvider(this).get(NoteViewModels::class.java)

        inp_title=findViewById(R.id.inp_title_edit)
        inp_content=findViewById(R.id.inp_contenido_edit)

        val id_note = intent.getLongExtra("id_note", 0L)
        intent.getStringExtra("title")?.let {
            inp_title.setText(it)
        }

        intent.getStringExtra("contenido")?.let {
            inp_content.setText(it)
        }

        findViewById<Button>(R.id.btn_save_edit)
            .setOnClickListener {
                val title = inp_title.text.toString()
                val content = inp_content.text.toString()

                if (title.isNotEmpty() && content.isNotEmpty()) {
                    noteViewModel.updateNote(id_note, title, content)
                    finish()
                }
            }

    }
}