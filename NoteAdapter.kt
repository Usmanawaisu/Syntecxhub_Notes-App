package com.example.notesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.data.Note

class NoteAdapter :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var noteList = emptyList<Note>()

    class NoteViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val title: TextView =
            itemView.findViewById(R.id.tvTitle)

        val description: TextView =
            itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)

        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: NoteViewHolder,
        position: Int
    ) {

        val currentNote = noteList[position]

        holder.title.text = currentNote.title
        holder.description.text =
            currentNote.description
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun setData(notes: List<Note>) {
        noteList = notes
        notifyDataSetChanged()
    }
}