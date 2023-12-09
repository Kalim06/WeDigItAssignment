package com.example.wedigitassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wedigitassignment.databinding.JamItemBinding

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private var data = listOf<ProfileJamsModel>()
    internal fun setData(dataList: List<ProfileJamsModel>) {
        this.data = dataList
    }

    class ViewHolder private constructor(private val binding: JamItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: ProfileJamsModel
        ) {
            binding.profileJams = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {

                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = JamItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the custom layout
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size


}