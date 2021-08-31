package com.example.simplestudentdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {

    lateinit var myAdapter:AdapterClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        var tempContactModel=ArrayList<DataClass>()
        var helper = MyDBHelper(this)
        var db = helper.readableDatabase
        var result = db.rawQuery("SELECT * FROM StudentDetails", null)
        if(!result.moveToNext())
            Toast.makeText(this, "No data", Toast.LENGTH_LONG).show()

        while(result.moveToNext())
        {
            var x = result.getColumnIndex("Id")
            var y = result.getColumnIndex("Name")
            var z = result.getColumnIndex("Age")

            var name = DataClass(
                result.getString(x).toString(), result.getString(y).toString(), result.getString(z).toString()
            )
            tempContactModel.add(name)
        }
        result.close()

        var layoutmanager = LinearLayoutManager(this)
        layoutmanager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutmanager
        myAdapter = AdapterClass(this, tempContactModel)
        recyclerView.adapter = myAdapter


    }
}