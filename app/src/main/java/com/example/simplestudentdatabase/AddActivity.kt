package com.example.simplestudentdatabase

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        var helper = MyDBHelper(this)
        var dbTable = helper.readableDatabase

        submit.setOnClickListener {
            var name = name_add.text.toString()
            var age = age.text.toString()


            var args = listOf<String?>(name,age).toTypedArray()
            var result = dbTable.rawQuery("SELECT * FROM StudentDetails WHERE Name= ? AND Age = ?",args)

            if (name.isEmpty() || age.isEmpty() )
                Toast.makeText(
                    this,
                    "Please fill all the fields ! ",
                    Toast.LENGTH_SHORT
                ).show()

            else if (result.moveToNext())
                Toast.makeText(
                    this,
                    "Student is already added ! ",
                    Toast.LENGTH_SHORT
                ).show()

            else {
                var cv = ContentValues()
                cv.put("Name", name)
                cv.put("Age",age)

                dbTable.insert("StudentDetails", null, cv)
                Toast.makeText(this, "Student added successfully!", Toast.LENGTH_SHORT).show()

            }
            result.close()
        }
    }
}