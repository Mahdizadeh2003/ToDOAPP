package com.myapplication.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.R
import com.myapplication.model.Todo

class Adaptor(private var todoList: MutableList<Todo>, var context: Context) :
    RecyclerView.Adapter<Adaptor.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var card = itemView.findViewById<CardView>(R.id.card)
        var titleTB = itemView.findViewById<TextView>(R.id.timeTextBox)
        var descriptionTB = itemView.findViewById<TextView>(R.id.descriptionTextBox)
        var dateTB = itemView.findViewById<TextView>(R.id.dateTextBox)
        var dateText = itemView.findViewById<TextView>(R.id.timeText)
        var timeText = itemView.findViewById<TextView>(R.id.timeText)
        var timeTB = itemView.findViewById<TextView>(R.id.timeTextBox)
        var isDoneCheckBox = itemView.findViewById<CheckBox>(R.id.isDoneCB)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_in_rec_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            titleTB.text = todoList[position].title
            descriptionTB.text = todoList[position].description
            dateTB.text = todoList[position].date
            timeTB.text = todoList[position].time
            isDoneCheckBox.isChecked = todoList[position].isDone
        }
    }
}