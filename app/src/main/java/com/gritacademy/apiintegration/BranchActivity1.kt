package com.gritacademy.apiintegration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class BranchActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_branch1)

        val backBtn = findViewById<Button>(R.id.backBtn)

        backBtn.setOnClickListener(View.OnClickListener {
            val a1 = Intent(this@BranchActivity1, MainActivity2::class.java)
            startActivity(a1)
        })

        getMyData()
    }

    private fun getMyData() {

        val retrofitBuilder =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(Apiinterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataTestItem>?> {
            override fun onResponse(
                call: Call<List<MyDataTestItem>?>,
                response: Response<List<MyDataTestItem>?>
            ) {
                val responseBody = response.body()!!
                val myStringBuilder = StringBuilder()
                for(myData in responseBody) {
                    myStringBuilder.append(myData.id)
                    myStringBuilder.append("\n")
                }
                val txtId = findViewById<TextView>(R.id.txtId)
                txtId.text = myStringBuilder
            }

            override fun onFailure(call: Call<List<MyDataTestItem>?>, t: Throwable) {
                Log.d("BranchActivity1", "onFailure: " + t.message)
            }
        })
    }
}