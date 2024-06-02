package com.example.borsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.borsapp.adapter.StockAdapter
import com.example.borsapp.databinding.FragmentHomeBinding
import com.example.borsapp.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: StockAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // RecyclerView için adapter oluştur
        adapter = StockAdapter(ArrayList())
        binding.stockRV.adapter = adapter
        binding.stockRV.layoutManager = LinearLayoutManager(requireContext())

        // ViewModel'i başlat
       //viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.getDataFromAPI()

        // Observer'ları ayarla
        setObservers()

        // Fragment'in görünümünü döndür
        return binding.root
    }

    private fun setObservers() {
        // StockData observer'ı
        viewModel.stockData.observe(viewLifecycleOwner, Observer { list ->
            adapter.updateStocks(list)
        })

        // StockLoad observer'ı
        viewModel.stockLoad.observe(viewLifecycleOwner, Observer { loading ->
            binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        })

        // StockError observer'ı
        viewModel.stockError.observe(viewLifecycleOwner, Observer { error ->
            binding.errorTV.visibility = if (error) View.VISIBLE else View.GONE
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Bağlamayı temizle
        binding.unbind()
    }
}