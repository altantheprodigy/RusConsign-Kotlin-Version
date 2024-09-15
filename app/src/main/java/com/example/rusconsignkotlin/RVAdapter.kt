package com.example.rusconsignkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RVAdapter (
    private val context: Context,
    private val dataList: ArrayList<Barang>
): RecyclerView.Adapter<RVAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val tvNameBarang = view.findViewById<TextView>(R.id.barang)
        val tvHarga = view.findViewById<TextView>(R.id.harga_barang)
        val tvRating = view.findViewById<TextView>(R.id.rating_barang)
        val imageView = view.findViewById<ImageView>(R.id.user_image)

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

        val imagePath = dataList.get(position).image_barang
        val fullImageUrl = "https://rusconsign.com/api${imagePath.replaceFirst("/storage", "/storage/public")}"

        // Load the image using Glide
        Glide.with(context)
            .load(fullImageUrl)
            .apply(RequestOptions().placeholder(R.drawable.logo)) // Optional placeholder
            .into(holder.imageView)
    }

    override fun getItemCount(): Int = dataList.size

    fun setData(data: ArrayList<Barang>){
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()

    }
}