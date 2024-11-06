// LeaderboardAdapter.kt
package com.example.phftv1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LeaderboardAdapter(private val leaderboardItems: List<LeaderboardItem>) :
    RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderboardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_leaderboard, parent, false)
        return LeaderboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeaderboardViewHolder, position: Int) {
        val item = leaderboardItems[position]
        holder.bind(item)
    }

    override fun getItemCount() = leaderboardItems.size

    inner class LeaderboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val rankTextView: TextView = itemView.findViewById(R.id.rank_text)
        private val usernameTextView: TextView = itemView.findViewById(R.id.username_text)
        private val pointsTextView: TextView = itemView.findViewById(R.id.points_text)

        fun bind(item: LeaderboardItem) {
            rankTextView.text = item.rank.toString()
            usernameTextView.text = item.username
            pointsTextView.text = item.points.toString()
        }
    }
}
