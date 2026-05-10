package com.example.notesapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.notesapp.data.Note
import com.example.notesapp.databinding.ActivityAddNoteBinding
import com.example.notesapp.viewmodel.NoteViewModel

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding

    private val viewModel: NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding =
            ActivityAddNoteBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSave.setOnClickListener {

            val title = binding.etTitle.text.toString()
            val desc = binding.etDescription.text.toString()

            if (title.isNotEmpty()) {

                val note = Note(
                    title = title,
                    description = desc
                )

                viewModel.insert(note)

                Toast.makeText(
                    this,
                    "Note Saved",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}