package com.example.borsapp.service

import com.example.borsapp.model.Hisse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HisseAPIService {
    //https://github.com/omergn7/RetrofitExampleDataset2
    val api = Retrofit.Builder().baseUrl("https://raw.githubusercontent.com/").addConverterFactory(GsonConverterFactory.create()).build().create(HisseAPI::class.java)

    fun getData() : Call<List<Hisse>> {
        return api.getHisse()
    }

}