package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.catalouge_activity.*
import com.example.test.CatalougeAdapter
import models.Fruit
import models.FruitResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import services.FruitApiInterface
import services.FruitApiService

class CatalougeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalouge_activity)

        rv_fruits_list.layoutManager = LinearLayoutManager(this)
        rv_fruits_list.setHasFixedSize(true)
        getFruitData { fruits : List<Fruit> ->
            rv_fruits_list.adapter = CatalougeAdapter(fruits)
        }

    }

    private fun getFruitData(callback: (List<Fruit>) -> Unit){
        val apiService = FruitApiService.getInstance().create(FruitApiInterface::class.java)
        apiService.getFruitList().enqueue(object : Callback<FruitResponse> {
            override fun onFailure(call: Call<FruitResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<FruitResponse>, response: Response<FruitResponse>) {
                return callback(response.body()!!.fruits)
            }

        })
    }
}