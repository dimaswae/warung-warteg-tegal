package com.example.warungwartegtegal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.warungwartegtegal.model.OrderModel

class OrderAdapter(private val orderList: ArrayList<OrderModel>) :
    RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvOrderName)
        val tvQty: TextView = itemView.findViewById(R.id.tvOrderQty)
        val tvPrice: TextView = itemView.findViewById(R.id.tvOrderPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = orderList[position]
        holder.tvName.text = item.name
        holder.tvQty.text = "${item.quantity}x"
        holder.tvPrice.text = "Rp ${item.price * item.quantity}"
    }

    override fun getItemCount(): Int = orderList.size
}
