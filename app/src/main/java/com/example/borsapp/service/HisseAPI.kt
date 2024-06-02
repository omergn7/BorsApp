package com.example.borsapp.service

import com.example.borsapp.model.Hisse
import retrofit2.Call
import retrofit2.http.GET

interface HisseAPI {
    //https://github.com/omergn7/RetrofitExampleDataset2
    @GET("omergn7/RetrofitExampleDataset2/main/hisseDataBase.json")
    fun getHisse() : Call<List<Hisse>>

}