package com.example.simplestudentdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_btn.setOnClickListener {
            var i = Intent(this,AddActivity::class.java)
            startActivity(i)
        }

        update_btn.setOnClickListener {
            var i = Intent(this,UpdateActivity::class.java)
            startActivity(i)
        }

        delete_btn.setOnClickListener {
            var i = Intent(this,DeleteActivity::class.java)
            startActivity(i)
        }

        display_btn.setOnClickListener {
            var i = Intent(this,DisplayActivity::class.java)
            startActivity(i)

        }


    }
}