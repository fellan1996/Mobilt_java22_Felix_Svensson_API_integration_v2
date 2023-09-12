package com.gritacademy.apiintegration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextBtn = findViewById<Button>(R.id.nextBtn)

        nextBtn.setOnClickListener(View.OnClickListener {
            val a1 = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(a1)
        })
    }
}