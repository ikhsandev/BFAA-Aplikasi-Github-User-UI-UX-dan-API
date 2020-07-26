package com.ikhsandicoding.submission02.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ikhsandicoding.submission02.R
import com.ikhsandicoding.submission02.model.DataFollowers
import kotlinx.android.synthetic.main.item_user.view.*

class ListDataFollowerAdapter(private val listDataFollower: ArrayList<DataFollowers>) :
    RecyclerView.Adapter<ListDataFollowerAdapter.ListDataHolder>() {

    fun setData(items: ArrayList<DataFollowers>) {
        listDataFollower.clear()
        listDataFollower.addAll(items)
        notifyDataSetChanged()
    }

    inner class ListDataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dataFollowers: DataFollowers) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(dataFollowers.avatar)
                    .apply(RequestOptions().override(100, 100))
                    .into(avatar)

                fullName.text = dataFollowers.name
                username.text =
                    itemView.context.getString(R.string.user, dataFollowers.username)
                count_repository.text =
                    itemView.context.getString(R.string.repository, dataFollowers.repository)
                count_followers.text =
                    itemView.context.getString(R.string.follower, dataFollowers.followers)
                count_following.text =
                    itemView.context.getString(R.string.followings, dataFollowers.following)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListDataHolder {
        return ListDataHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listDataFollower.size
    }

    override fun onBindViewHolder(holder: ListDataHolder, position: Int) {
        holder.bind(listDataFollower[position])
    }
}