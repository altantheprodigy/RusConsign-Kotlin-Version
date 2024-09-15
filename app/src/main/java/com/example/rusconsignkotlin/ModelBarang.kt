package com.example.rusconsignkotlin

//package quicktype

data class ModelBarang (
    val message: String,
    val barangs: List<Barang>
)

data class Barang (
    val id: Long,
    val nama_barang: String,
    val deskripsi: String,
    val harga: Long,
    val rating_barang: Double,
    val categoryID: Long,
    val categoryNama: String,
    val image_barang: String,
    val status: String,
    val stock: Long,
    val quantity: Long,
    val createdAt: String,
    val updatedAt: String,
    val mitra: Mitra
)

data class Mitra (
    val id: Long,
    val namaToko: Any? = null,
    val namaLengkap: String,
    val jumlahProduct: Long,
    val jumlahJasa: Long,
    val pengikut: Long,
    val penilaian: Long,
    val noWhatsapp: String,
    val profileImage: String? = null
)
