package services

import models.FruitResponse
import retrofit2.Call
import retrofit2.http.GET

interface FruitApiInterface {

    @GET("/api/fruit/all")
    fun getFruitList(): Call<FruitResponse>
}