package com.example.simplestudentdatabase

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_delete.*
import kotlinx.android.synthetic.main.activity_update.*

class UpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        update.setOnClickListener {

            var name = update_name.text.toString()
            var arg = arrayOf(name)
            var age = update_age.text.toString()

            var helper = MyDBHelper(this)
            var dbTable = helper.readableDatabase

            var result =
                dbTable.rawQuery("SELECT Name FROM StudentDetails WHERE Name=?", arg)

            if (name.isEmpty())
                Toast.makeText(this, "Please enter the name to be updated", Toast.LENGTH_LONG)
                    .show()

            else if (result.moveToNext()) {

                var cv = ContentValues()
                cv.put("Age",age)

                dbTable.update("StudentDetails",cv,"Name=?",arg)
                Toast.makeText(this, "Successfully Updated", Toast.LENGTH_LONG).show()

            }
            else
                Toast.makeText(this, "Student doesn't exist", Toast.LENGTH_LONG).show()


            result.close()
            dbTable.close()
        }
    }
}