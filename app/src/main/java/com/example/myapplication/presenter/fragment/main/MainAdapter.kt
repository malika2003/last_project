package com.example.myapplication.presenter.fragment.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemNotesBinding
import com.example.myapplication.domain.model.Note

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    private val list: MutableList<Note> = ArrayList()



    @SuppressLint("NotifyDataSetChanged")
    fun setList(lst: List<Note>){
        this.list.clear()
        this.list.addAll(lst)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


    inner class ViewHolder(private val binding: ItemNotesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(note: Note){
            binding.txtTitle.text = note.title
            binding.txtDesc.text = note.desc
            binding.txtDate.text = note.date
        }
    }
}