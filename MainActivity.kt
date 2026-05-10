package com.example.notesapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.adapter.NoteAdapter
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: NoteViewModel by viewModels()

    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        adapter = NoteAdapter()

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this)

        binding.recyclerView.adapter = adapter

        viewModel.allNotes.observe(this) {

            adapter.setData(it)
        }

        binding.fabAdd.setOnClickListener {

            startActivity(
                Intent(this, AddNoteActivity::class.java)
            )
        }
    }
}