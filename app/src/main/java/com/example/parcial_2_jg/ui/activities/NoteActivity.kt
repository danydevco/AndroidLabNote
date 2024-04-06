package com.example.parcial_2_jg.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.parcial_2_jg.R
import com.example.parcial_2_jg.ui.viewModels.NoteViewModels

class NoteActivity : AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModels
    lateinit var inp_title: TextView
    lateinit var inp_content: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        noteViewModel= ViewModelProvider(this).get(NoteViewModels::class.java)

        inp_title=findViewById(R.id.title_note_final)
        inp_content=findViewById(R.id.contenido_note_final)

        val id_note = intent.getLongExtra("id_note", 0L)
        intent.getStringExtra("title")?.let {
            inp_title.setText(it)
        }

        intent.getStringExtra("contenido")?.let {
            inp_content.setText(it)
        }

//        findViewById<Button>(R.id.btn_edit_note_full).setOnClickListener {
//            val intent = Intent(it.context, EditNoteActivity::class.java)
//            intent.putExtra("id_note", note.nid)
//            intent.putExtra("title", note.title)
//            intent.putExtra("contenido", note.content)
//            it.context.startActivity(intent)
//            startActivity(intent)
//        }
//
//        findViewById<Button>(R.id.btn_delete_note_full).setOnClickListener {
//            noteViewModel.deleteNote(note)
//            finish()
//        }
    }
}