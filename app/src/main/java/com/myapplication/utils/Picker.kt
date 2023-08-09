package com.myapplication.utils

import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class Picker(private var fragmentManager: FragmentManager, private var editText: EditText) {
    init {
        makeDatePicker()
    }

    private fun makeTimePicker() {
        val timePicker: MaterialTimePicker =
            MaterialTimePicker.Builder().setTitleText("Select Time")
                .setTimeFormat(TimeFormat.CLOCK_24H).build()
        timePicker.show(fragmentManager, "time Picker in addTask")
        timePicker.addOnPositiveButtonClickListener {
            hour = timePicker.hour
            minute = timePicker.minute
            val result = "$fullDate , $hour : $minute"
            editText.setText(result)
        }
    }

    private fun makeDatePicker() {
        val datePicker =
            MaterialDatePicker.Builder.datePicker().setTitleText("Select Time").build()
        datePicker.show(fragmentManager, "datePickerInAddTASK")

        datePicker.addOnPositiveButtonClickListener {
            val outPutDateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            outPutDateFormat.timeZone = TimeZone.getTimeZone("UTC")
            fullDate = outPutDateFormat.format(it)
            makeTimePicker()
        }


    }
}