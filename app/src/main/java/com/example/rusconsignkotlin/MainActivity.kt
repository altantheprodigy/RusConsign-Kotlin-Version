package com.example.rusconsignkotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rusconsignkotlin.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the adapter with an empty list
        adapter = RVAdapter(this@MainActivity, arrayListOf())

        // Set up RecyclerView with a layout manager
        binding.recyclerView.layoutManager = GridLayoutManager(this,2)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)

        // Fetch the product data
        remoteGetProduct()
    }

    fun remoteGetProduct() {
        ApiClient.apiService.getAcceptedBarangs().enqueue(object : Callback<ModelBarang> {
            override fun onResponse(call: Call<ModelBarang>, response: Response<ModelBarang>) {
                if (response.isSuccessful) {
                    response.body()?.let { modelBarang ->
                        val barangs = ArrayList(modelBarang.barangs) // Get the list of barangs from the response
                        setDataToAdapter(barangs)
                        Log.d("MainActivity", "Received ${barangs.size} items")
                    }
                } else {
                    Log.e("MainActivity", "Failed to get data: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<ModelBarang>, t: Throwable) {
                Log.e("MainActivity", "API call failed: ${t.message}")
            }
        })
    }

    fun setDataToAdapter(data: ArrayList<Barang>) {
        adapter.setData(data)
    }
}
