package com.example.warungwartegtegal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.warungwartegtegal.databinding.ActivityHomeBinding
import com.example.warungwartegtegal.data.MenuItem
import com.example.warungwartegtegal.MenuAdapter
//import com.example.warungwartegtegal.OrderActivity


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Warung Warteg Tegal"

        // Dummy menu data
        val menuItems = listOf(
            MenuItem("Nasi Rames", "Rp 15.000"),
            MenuItem("Ayam Goreng", "Rp 13.000"),
            MenuItem("Sayur Asem", "Rp 6.000"),
            MenuItem("Tahu Tempe Goreng", "Rp 5.000"),
            MenuItem("Ikan Lele Goreng", "Rp 12.000"),
        )

        // Setup RecyclerView
        adapter = MenuAdapter(menuItems)
        binding.rvMenu.layoutManager = LinearLayoutManager(this)
        binding.rvMenu.adapter = adapter

        // Order button click
        binding.btnOrder.setOnClickListener {
            val selectedItems = adapter.getSelectedItems()

            if (selectedItems.isEmpty()) {
                Toast.makeText(this, "Pilih menu dulu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, OrderActivity::class.java)
            intent.putParcelableArrayListExtra("cart", ArrayList(selectedItems))
            startActivity(intent)
        }
    }
}
