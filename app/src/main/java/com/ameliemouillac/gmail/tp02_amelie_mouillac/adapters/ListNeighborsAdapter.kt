package com.ameliemouillac.gmail.tp02_amelie_mouillac.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ameliemouillac.gmail.tp02_amelie_mouillac.R
import com.ameliemouillac.gmail.tp02_amelie_mouillac.databinding.NeighborItemBinding
import com.ameliemouillac.gmail.tp02_amelie_mouillac.models.Neighbor
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListNeighborsAdapter(
    items: List<Neighbor>,
    private val listNeighborHandler: ListNeighborHandler
) : RecyclerView.Adapter<ListNeighborsAdapter.ViewHolder>() {

    private val mNeighbours: List<Neighbor> = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NeighborItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = mNeighbours.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewHolder = holder as ViewHolder
        val neighbor = mNeighbours[position]
        itemViewHolder.viewBinding.itemListName.text = neighbor.name

        val context = holder.viewBinding.root.context
        // Display Neighbour Avatar
        Glide.with(context)
            .load(neighbor.avatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_person)
            .error(R.drawable.ic_person)
            .skipMemoryCache(false)
            .into(itemViewHolder.viewBinding.itemListAvatar)

        itemViewHolder.viewBinding.itemListDeleteButton.setOnClickListener {
            listNeighborHandler.onDeleteNeighbor(neighbor)
        }
    }

    class ViewHolder(var viewBinding: NeighborItemBinding) : RecyclerView.ViewHolder(viewBinding.root)
}
