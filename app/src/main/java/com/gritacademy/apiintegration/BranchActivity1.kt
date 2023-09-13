package com.gritacademy.apiintegration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class BranchActivity1 : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_branch1)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_users)
        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

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

                val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_users)
                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerView.adapter = myAdapter

            }

            override fun onFailure(call: Call<List<MyDataTestItem>?>, t: Throwable) {
                d("BranchActivity1", "onFailure: " + t.message)
            }
        })
    }
}