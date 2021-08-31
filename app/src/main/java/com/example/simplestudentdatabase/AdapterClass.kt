package com.example.simplestudentdatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_each_student.view.*
import java.util.ArrayList

class AdapterClass(var context: Context,var studentList: ArrayList<DataClass>) :RecyclerView.Adapter<AdapterClass.View>(){
    inner class View(var inner_view: android.view.View):RecyclerView.ViewHolder(inner_view){

        fun studentData(student:DataClass?,position: Int){
            itemView.studentId.text = "Student ID: "+ student?.id
            itemView.studentName.text = "Name :"+ student?.name
            itemView.studentAge.text = "Age : "+ student?.age
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): View {
        var v = LayoutInflater.from(context).inflate(R.layout.activity_each_student,parent,false)
        return View(v)
    }

    override fun onBindViewHolder(holder: View, position: Int) {
        var pos = studentList[position]
        holder.studentData(pos,position)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}