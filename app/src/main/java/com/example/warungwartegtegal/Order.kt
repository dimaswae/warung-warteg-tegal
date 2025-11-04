package com.example.warungwartegtegal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.warungwartegtegal.databinding.ActivityOrderBinding
import com.example.warungwartegtegal.model.OrderModel

class OrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // terima data dari Home
        val orders = intent.getSerializableExtra("order_list") as ArrayList<OrderModel>

        // tampilkan ke RecyclerView
        binding.rvOrders.layoutManager = LinearLayoutManager(this)
        binding.rvOrders.adapter = OrderAdapter(orders)

        // hitung total harga
        val total = orders.sumOf { it.price * it.quantity }
        binding.tvTotalPrice.text = "Rp $total"

        binding.btnKirim.setOnClickListener {
            val intent = Intent(this, AddressActivity::class.java)
            startActivity(intent)
        }
    }
}
