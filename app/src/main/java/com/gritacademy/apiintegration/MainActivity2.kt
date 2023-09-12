package com.gritacademy.apiintegration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val nextBtn = findViewById<Button>(R.id.nextBtn)

        nextBtn.setOnClickListener(View.OnClickListener {
            val a1 = Intent(this@MainActivity2, BranchActivity1::class.java)
            startActivity(a1)
        })
        val nextBtn2 = findViewById<Button>(R.id.nextBtn2)

        nextBtn2.setOnClickListener(View.OnClickListener {
            val a1 = Intent(this@MainActivity2, BranchActivity2::class.java)
            startActivity(a1)
        })

        val backBtn = findViewById<Button>(R.id.backBtn)

        backBtn.setOnClickListener(View.OnClickListener {
            val a1 = Intent(this@MainActivity2, MainActivity::class.java)
            startActivity(a1)
        })

    }
}