package com.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.myapplication.R
import com.myapplication.databinding.FragmentAddTaskBinding
import com.myapplication.model.Todo
import com.myapplication.utils.Picker
import com.myapplication.utils.fullDate
import com.myapplication.utils.hour
import com.myapplication.utils.minute

class AddTask : Fragment() {
    private lateinit var binding: FragmentAddTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.dateTextInput.setOnClickListener {
            Picker(parentFragmentManager, binding.dateTextInput)
        }
        binding.addTaskBTN.setOnClickListener {
            val newTodo = Todo(
                binding.titleEditText.editText?.text.toString(),
                binding.descriptionEditText.editText?.text.toString(),
                "$hour:$minute", fullDate, false
            )
            todoList.add(newTodo)
            Navigation.findNavController(binding.addTaskBTN)
                .navigate(R.id.action_addTask_to_currentTTodos)
        }
    }

}