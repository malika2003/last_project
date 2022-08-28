package com.example.myapplication.presenter.fragment.main

import com.example.myapplication.core.BaseViewModel
import com.example.myapplication.domain.model.Note
import com.example.myapplication.domain.use_cases.AddNoteUseCase
import com.example.myapplication.domain.use_cases.DeleteNoteUseCase
import com.example.myapplication.domain.use_cases.GetAllNotesUseCase
import com.example.myapplication.domain.use_cases.UpdateNoteUseCase
import com.example.myapplication.utils.Const.UNKNOWN_ERROR
import com.example.myapplication.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
) : BaseViewModel() {

    private val _addNoteLd = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val addNoteState = _addNoteLd.asStateFlow()

    private val _getAllNotesLD = MutableStateFlow<UIState<List<Note>>>(UIState.Loading())
    val getAllNotesState = _getAllNotesLD.asStateFlow()

    private val _deleteNoteLd = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val deleteNotesState = _deleteNoteLd.asStateFlow()

    private val _editNoteLd = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val editNotesState = _editNoteLd.asStateFlow()

    fun addNote(note: Note)  {
        addNoteUseCase.addNote(note).getData(
            { error ->
                _addNoteLd.value = UIState.Error(error ?: UNKNOWN_ERROR)
            }, {
                _addNoteLd.value = UIState.Loading()
            },
            { data ->
                _addNoteLd.value = data?.let { UIState.Success(it) }!!
            }
        )
    }

    fun getAllNotes()  {
        getAllNotesUseCase.getAllNotes().getData(
            { error ->
                _getAllNotesLD.value = UIState.Error(error ?: UNKNOWN_ERROR)
            }, {
                _getAllNotesLD.value = UIState.Loading()
            },
            { data ->
                _getAllNotesLD.value = data?.let { UIState.Success(it) }!!
            }
        )
    }

    fun deleteNote(note: Note)  {
        deleteNoteUseCase.deleteNote(note).getData(
            { error ->
                _deleteNoteLd.value = UIState.Error(error ?: UNKNOWN_ERROR)
            }, {
                _deleteNoteLd.value = UIState.Loading()
            },
            { data ->
                _deleteNoteLd.value = data?.let { UIState.Success(it) }!!
            }
        )
    }

    fun editNote(id: Int, note: Note)  {
        updateNoteUseCase.updateNote(id, note).getData(
            { error ->
                _editNoteLd.value = UIState.Error(error ?: UNKNOWN_ERROR)
            }, {
                _editNoteLd.value = UIState.Loading()
            },
            { data ->
                _editNoteLd.value = data?.let { UIState.Success(it) }!!
            }
        )
    }
}