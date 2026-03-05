package com.example.daftarbuahinteraktif // sesuaikan dengan package Anda

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Deklarasi komponen
    private lateinit var listView: ListView
    private lateinit var editTextBuah: EditText
    private lateinit var buttonTambah: Button

    // Data awal (isi buah)
    private val daftarBuah = mutableListOf(
        "Apel", "Pisang", "Jeruk", "Mangga", "Anggur",
        "Semangka", "Melon", "Pepaya", "Jambu", "Nanas",
        "Durian", "Rambutan", "Manggis", "Salak", "Markisa"
    )

    // Adapter
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen
        listView = findViewById(R.id.listViewBuah)
        editTextBuah = findViewById(R.id.editTextBuah)
        buttonTambah = findViewById(R.id.buttonTambah)

        // Setup adapter
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            daftarBuah
        )

        // Item click listener
        listView.setOnItemClickListener { parent, _, position, _ ->
            val buahTerpilih = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "Anda memilih $buahTerpilih", Toast.LENGTH_SHORT).show()
        }

        // Tombol tambah buah
        buttonTambah.setOnClickListener {
            val buahBaru = editTextBuah.text.toString().trim()
            if (buahBaru.isNotEmpty()) {
                daftarBuah.add(buahBaru)              // Tambah ke data list
                adapter.notifyDataSetChanged()        // Refresh ListView
                editTextBuah.text.clear()             // Kosongkan EditText
            } else {
                Toast.makeText(this, "Masukkan nama buah terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
        listView.adapter = adapter

    }
}