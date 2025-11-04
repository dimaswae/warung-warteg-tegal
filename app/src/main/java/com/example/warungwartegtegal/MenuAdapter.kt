package com.example.warungwartegtegal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.warungwartegtegal.databinding.ItemMenuBinding
import com.example.warungwartegtegal.data.MenuItem

class MenuAdapter(private val menuList: List<MenuItem>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemMenuBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = menuList[position]

        holder.binding.tvFoodName.text = item.name
        holder.binding.tvFoodPrice.text = item.price
        holder.binding.imgFood.setImageResource(item.imageRes)  // <─ Tambahan

        holder.binding.cbSelect.isChecked = item.isSelected

        holder.binding.cbSelect.setOnCheckedChangeListener { _, checked ->
            item.isSelected = checked
        }
    }


    override fun getItemCount() = menuList.size

    fun getSelectedItems(): List<MenuItem> {
        return menuList.filter { it.isSelected }
    }
}

