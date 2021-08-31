package com.example.simplestudentdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_delete.*

class DeleteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)



        delete.setOnClickListener {
            var name = delete_name.text.toString()
            var arg = arrayOf(name)
            var helper = MyDBHelper(this)
            var dbTable = helper.readableDatabase
            var result =
                dbTable.rawQuery("SELECT Name FROM StudentDetails WHERE Name=?", arg)

            if(name.isEmpty())
                Toast.makeText(this, "Please enter the name to be deleted", Toast.LENGTH_LONG).show()


            else if (result.moveToNext()) {
                deleteData(name)
                Toast.makeText(this, "Successfully Deleted", Toast.LENGTH_LONG).show()
                delete_name.setText("")
                delete_name.requestFocus()

            } else
                Toast.makeText(this, "Student doesn't exist", Toast.LENGTH_LONG).show()


            result.close()
        }
    }
    private fun deleteData(name: String) {


        var studentName = arrayOf(name)
        var helper = MyDBHelper(this)
        var dbTable = helper.readableDatabase

        dbTable.delete("StudentDetails", "Name=?", studentName)
        dbTable.close()


    }
}