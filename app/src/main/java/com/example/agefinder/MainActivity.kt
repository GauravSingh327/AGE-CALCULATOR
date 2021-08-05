package com.example.agefinder

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mybtn = findViewById<Button>(R.id.btnDatePicker)
        mybtn.setOnClickListener { view ->
            clickDatePicker(view)
            Toast.makeText(this,"Clicked !!!",Toast.LENGTH_LONG).show()
        }

    }
    fun clickDatePicker(view: View)
    {
           val myCalender = Calendar.getInstance()
           val  year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day =myCalender.get(Calendar.DAY_OF_MONTH)

           val dpd = DatePickerDialog(this,
               DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
               Toast.makeText(this,
                   "Date has been picked confirm that it is right date and the year is $selectedYear the month is ${selectedMonth+1} , the day is ${selectedDayOfMonth}"
                   ,Toast.LENGTH_LONG).show()
                   val selectedDate ="$selectedDayOfMonth/${selectedMonth+1}/${selectedYear}"
                   val tvDate =findViewById<TextView>(R.id.tvSelectedDate)
                   tvDate.setText(selectedDate)
                   val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                   val theDate =sdf.parse(selectedDate)
                   val selectedDateInMin =theDate!!.time/60000
                   val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                   val currentDateInMin = currentDate!!.time/60000
                   val differenceInMin = currentDateInMin -selectedDateInMin
                   val tvMinutes =findViewById<TextView>(R.id.tvSelectedDateInMinutes)
                   tvMinutes.setText(differenceInMin.toString())

           },year,month,day)
        dpd.datePicker.setMaxDate(Date().time-86400000)
        dpd.show()
    }

}