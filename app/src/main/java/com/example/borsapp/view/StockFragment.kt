package com.example.borsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.borsapp.databinding.FragmentStockBinding
import com.example.borsapp.viewmodel.StockViewModel
import android.widget.Toast


class StockFragment : Fragment() {

    private var _binding: FragmentStockBinding? = null
    private val binding get() = _binding!!

    private var totalCost = 0.0
    private var totalAmount = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStockBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener {
            addStock()
        }
    }

    private fun addStock() {
        val stockPriceText = binding.etSharePrice.text.toString()
        val stockAmountText = binding.etShareQuantity.text.toString()

        if (stockPriceText.isNotEmpty() && stockAmountText.isNotEmpty()) {
            val stockPrice = stockPriceText.toDouble()
            val stockAmount = stockAmountText.toInt()

            totalCost += stockPrice * stockAmount
            totalAmount += stockAmount

            val averagePrice = if (totalAmount > 0) totalCost / totalAmount else 0.0

            binding.tvTotalCost.text = "Toplam Maliyet: $totalCost"
            binding.tvAveragePrice.text = "Ortalama Fiyat: $averagePrice"
        } else {
            Toast.makeText(requireContext(), "Lütfen hisse fiyatı ve miktarını girin", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}