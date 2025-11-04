package com.example.warungwartegtegal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.warungwartegtegal.databinding.ActivityConfirmationBinding

class ConfirmationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set data from intent
        val customerName = intent.getStringExtra("CUSTOMER_NAME") ?: "Customer"
        val deliveryAddress = intent.getStringExtra("DELIVERY_ADDRESS") ?: "Address not provided"
        val notes = intent.getStringExtra("NOTES") ?: ""

        binding.tvCustomerName.text = "Nama: $customerName"
        binding.tvDeliveryAddress.text = "Alamat: $deliveryAddress"

        if (notes.isNotEmpty()) {
            binding.tvOrderDetails.text = "Catatan: $notes"
        }

        binding.btnBackToHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}