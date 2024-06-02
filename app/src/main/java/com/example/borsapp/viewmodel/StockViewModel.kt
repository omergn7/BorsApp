package com.example.borsapp.viewmodel
import androidx.lifecycle.ViewModel

class StockViewModel : ViewModel() {

    // Hisse senedi verileri
    private val stockData: List<Stock> = listOf(
        Stock("AAPL", "Apple Inc.", 150.0),
        Stock("GOOGL", "Alphabet Inc.", 2500.0),
        Stock("MSFT", "Microsoft Corporation", 300.0)
        // Diğer hisse senedi verileri buraya eklenebilir
    )

    // Hisse senedi verilerini döndüren fonksiyon
    fun getStocks(): List<Stock> {
        return stockData
    }


}

// Hisse senedi sınıfı
data class Stock(
    val symbol: String,
    val name: String,
    val price: Double
)