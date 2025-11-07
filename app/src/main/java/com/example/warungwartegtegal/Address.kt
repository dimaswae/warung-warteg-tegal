package com.example.warungwartegtegal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.warungwartegtegal.databinding.ActivityAddressBinding

class AddressActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirmOrder.setOnClickListener {
            confirmOrder()
        }
    }

    private fun confirmOrder() {
        val customerName = binding.etCustomerName.text.toString().trim()
        val deliveryAddress = binding.etDeliveryAddress.text.toString().trim()
        val notes = binding.etNotes.text.toString().trim()

        if (customerName.isEmpty() || deliveryAddress.isEmpty()) {
            Toast.makeText(this, "Please fill customer name and delivery address", Toast.LENGTH_SHORT).show()
            return
        }

        val intent = Intent(this, ConfirmationActivity::class.java).apply {
            putExtra("CUSTOMER_NAME", customerName)
            putExtra("DELIVERY_ADDRESS", deliveryAddress)
            putExtra("NOTES", notes)
        }
        startActivity(intent)
    }
}