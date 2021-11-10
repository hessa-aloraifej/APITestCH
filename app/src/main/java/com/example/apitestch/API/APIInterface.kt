package com.example.apitestch.API

import com.example.apitestch.JSON.DICDetailsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface APIInterface {
    @GET()
    fun getPhoto(@Url url:String): Call<List<DICDetailsItem?>>?
}