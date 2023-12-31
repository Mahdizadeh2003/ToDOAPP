package com.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapplication.R
import com.myapplication.adaptor.Adaptor
import com.myapplication.databinding.FragmentAddTaskBinding
import com.myapplication.databinding.FragmentCurrentTTodosBinding
import com.myapplication.model.Todo

val todoList = mutableListOf<Todo>()
class currentTodos : Fragment() {
    private lateinit var binding: FragmentCurrentTTodosBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrentTTodosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addTasBTN.setOnClickListener {
            Navigation.findNavController(binding.addTasBTN).navigate(R.id.action_currentTTodos_to_addTask)
        }

    }

    override fun onResume() {
        super.onResume()
        initRecView()
    }

    private fun initRecView(){
        val adaptor = Adaptor(todoList , requireContext())
        binding.recView.adapter = adaptor
        binding.recView.layoutManager = LinearLayoutManager(requireContext())
    }
}