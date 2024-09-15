package com.example.rusconsignkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter (
    private val context: Context,
    private val dataList: ArrayList<Barang>
): RecyclerView.Adapter<RVAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val tvNameBarang = view.findViewById<TextView>(R.id.barang)
        val tvHarga = view.findViewById<TextView>(R.id.harga_barang)
        val tvRating = view.findViewById<TextView>(R.id.rating_barang)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.card_product,parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvNameBarang.text = dataList.get(position).nama_barang
        holder.tvHarga.text = dataList.get(position).harga.toString()
        holder.tvRating.text = dataList.get(position).rating_barang.toString()
    }

    override fun getItemCount(): Int = dataList.size

    fun setData(data: ArrayList<Barang>){
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()

    }
}