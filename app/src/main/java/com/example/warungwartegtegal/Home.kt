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
            MenuItem("Nasi Rames", "Rp 15.000", R.drawable.nasi_rames),
            MenuItem("Ayam Goreng", "Rp 13.000", R.drawable.ayam_goreng),
            MenuItem("Sayur Asem", "Rp 6.000", R.drawable.sayur_asem),
            MenuItem("Tahu Tempe Goreng", "Rp 5.000", R.drawable.tahu_tempe),
            MenuItem("Ikan Lele Goreng", "Rp 12.000", R.drawable.lele_goreng),
            MenuItem("Ayam Bakar", "Rp 10.000", R.drawable.ayam_bakar),
            MenuItem("Paket 10rb", "Rp 10.000", R.drawable.paket_10rb),
            MenuItem("Tongkol Balado", "Rp 5.000", R.drawable.tongkol_balado),
            MenuItem("Nasi", "Rp 5.000", R.drawable.nasi),
            MenuItem("Oreg Tempe", "Rp 4.000", R.drawable.oreg_tempe),
            MenuItem("Es Teh", "Rp 3.000", R.drawable.es_teh),
            MenuItem("Es Jeruk", "Rp 3.000", R.drawable.es_jeruk),
            MenuItem("Es Campur", "Rp 5.000", R.drawable.es_campur),
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
