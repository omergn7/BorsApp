package com.example.borsapp.viewmodel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.borsapp.model.Hisse
import com.example.borsapp.service.HisseAPIService
import com.example.borsapp.viewmodel.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val hisseAPI = HisseAPIService()

    private val _stockData = MutableLiveData<List<Hisse>>()
    val stockData: MutableLiveData<List<Hisse>>
        get() = _stockData

    private val _stockError = MutableLiveData<Boolean>()
    val stockError: MutableLiveData<Boolean>
        get() = _stockError

    private val _stockLoad = MutableLiveData<Boolean>()
    val stockLoad: MutableLiveData<Boolean>
        get() = _stockLoad

    init {
        // ViewModel oluşturulduğunda dummy verileri yükleme işlemi
        getDataFromAPI()
    }

    fun getDataFromAPI() {
     _stockLoad.value=true
        hisseAPI.getData().enqueue(object: Callback<List<Hisse>>{
            override fun onResponse(call: Call<List<Hisse>>, response: Response<List<Hisse>>) {
                _stockData.value=response.body()
                _stockError.value=false
                _stockLoad.value=false
            }

            override fun onFailure(call: Call<List<Hisse>>, t: Throwable) {
                _stockLoad.value=false
                _stockError.value=true
                Log.e("Retrofit Error", t.message.toString())
            }


        })

    }
}
/*
private fun createDummyData() {
    val stock1 = Hisse("Boğaziçi Beton Sanayi", "BOBET")
    val stock2 = Hisse("Boğaziçi Beton Sanayi", "BOBET")
    val stock3 = Hisse("Boğaziçi Beton Sanayi", "BOBET")
    val stock4 = Hisse("Boğaziçi Beton Sanayi", "BOBET")
    val stock5 = Hisse("Boğaziçi Beton Sanayi", "BOBET")
    val stock6 = Hisse("Boğaziçi Beton Sanayi", "BOBET")
    val list = arrayListOf(stock1, stock2,stock3,stock4,stock5,stock6)

    _stockData.value = list
    _stockError.value = false
    _stockLoad.value = false
}*/