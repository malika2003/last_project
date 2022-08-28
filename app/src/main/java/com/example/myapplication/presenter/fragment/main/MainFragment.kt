package com.example.myapplication.presenter.fragment.main

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.myapplication.core.BaseFragment
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.domain.model.Note
import com.example.myapplication.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private lateinit var adapter: MainAdapter
    private val viewModel : MainViewModel by viewModels()

    override fun setupUI() {
        initAdapter()
        initViewModel()
        getNote()
    }

    private fun getNote() {
    }

    override fun setupObserver() {
        super.setupObserver()
        openAddNoteFragment()
    }

    private fun openAddNoteFragment() {
    }

    private fun initViewModel() {
        viewModel.getAllNotes()

        var i = 0
        binding().btnAddNote.setOnClickListener{
            i++
            val e = Date()
            viewModel.addNote(
                Note(
                    title = "title $i",
                    desc = "desc $i",
                    date = "$e"
                )
            )
        }

        viewModel.addNoteState.subscribe {
            when (it) {
                is UIState.Error -> {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }
                is UIState.Loading -> {
                }
                is UIState.Success -> {
                    viewModel.getAllNotes()
                }
            }
        }


        viewModel.getAllNotesState.subscribe {
            when (it) {
                is UIState.Error -> {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }
                is UIState.Loading -> {
                }
                is UIState.Success -> {
                    adapter.setList(it.data)
                }
            }
        }
    }

    private fun initAdapter() {
        adapter = MainAdapter()
        binding().rvNotes.adapter = adapter
    }

}