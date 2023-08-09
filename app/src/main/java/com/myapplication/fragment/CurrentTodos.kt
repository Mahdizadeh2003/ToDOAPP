package com.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.myapplication.R
import com.myapplication.databinding.FragmentAddTaskBinding
import com.myapplication.databinding.FragmentCurrentTTodosBinding

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
}