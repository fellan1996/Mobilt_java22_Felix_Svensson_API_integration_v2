package com.gritacademy.apiintegration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class BranchActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_branch2)

        val backBtn = findViewById<Button>(R.id.backBtn)

        backBtn.setOnClickListener(View.OnClickListener {
            val a1 = Intent(this@BranchActivity2, MainActivity2::class.java)
            startActivity(a1)
        })
    }
}