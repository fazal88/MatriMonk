package com.androidvoyage.matrimonk.matchlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.androidvoyage.matrimonk.database.MatchItem
import com.androidvoyage.matrimonk.databinding.ItemMatchesBinding


open class MatchListAdapter(val clickListener : MatchClickListener) : ListAdapter<MatchItem, MatchListAdapter.ViewHolder>(
    MatchesDiffCallback()
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position),clickListener)

    class MatchesDiffCallback : DiffUtil.ItemCallback<MatchItem>(){
        override fun areItemsTheSame(oldItem: MatchItem, newItem: MatchItem): Boolean = oldItem.matchId == newItem.matchId

        override fun areContentsTheSame(oldItem: MatchItem, newItem: MatchItem): Boolean = oldItem == newItem
    }

    class ViewHolder private constructor(val binding: ItemMatchesBinding) : RecyclerView.ViewHolder(binding.root) {
        val res = itemView.context.resources
        fun bind(item: MatchItem, clickListener: MatchClickListener) {
            binding.match = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val binding = ItemMatchesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class MatchClickListener(val acceptListener: (match: MatchItem) -> Unit,
                             val declineListener: (match: MatchItem) -> Unit) {

        fun onAccept(item: MatchItem) = acceptListener(item)

        fun onDecline(item: MatchItem) = declineListener(item)
    }




}