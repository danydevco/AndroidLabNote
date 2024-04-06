package com.example.parcial_2_jg.ui.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_2_jg.data.model.NoteModel
import com.example.parcial_2_jg.R
import com.example.parcial_2_jg.ui.activities.EditNoteActivity
import com.example.parcial_2_jg.ui.activities.NoteActivity
import com.example.parcial_2_jg.ui.viewModels.NoteViewModels



class NoteAdapter (private val notes:List<NoteModel>, private val noteViewModel: NoteViewModels):RecyclerView.Adapter<NoteAdapter.ViewHolder>(){


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(note:NoteModel){
            Log.d("NoteAdapter", "Nota: ${note.title}")
            itemView.findViewById<TextView>(R.id.title_note).text = note.title
            itemView.findViewById<TextView>(R.id.contenido_note).text = if (note.content.length >= 10) {
                note.content.subSequence(0, 10)
            } else {
                note.content
            }

        }
    }

    override fun getItemCount(): Int {
        Log.d("NoteAdapter", "Notas: ${notes.size}")
        return notes.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_note_rv, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val note=notes[position]
        holder.bind(note)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, NoteActivity::class.java)
            intent.putExtra("id_note", note.nid)
            intent.putExtra("title", note.title)
            intent.putExtra("contenido", note.content)
            it.context.startActivity(intent)
        }

        holder.itemView.findViewById<Button>(R.id.btn_edit_note_view)
            .setOnClickListener {
                val intent = Intent(it.context, EditNoteActivity::class.java)
                intent.putExtra("id_note", note.nid)
                intent.putExtra("title", note.title)
                intent.putExtra("contenido", note.content)
                it.context.startActivity(intent)

            }


        holder.itemView.findViewById<Button>(R.id.btn_delete_note_view)
            .setOnClickListener {
                noteViewModel.deleteNote(note)
            }

    }
}