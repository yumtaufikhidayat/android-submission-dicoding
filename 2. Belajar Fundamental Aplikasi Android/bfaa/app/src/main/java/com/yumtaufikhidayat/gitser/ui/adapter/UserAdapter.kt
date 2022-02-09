package com.yumtaufikhidayat.gitser.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yumtaufikhidayat.gitser.data.User
import com.yumtaufikhidayat.gitser.databinding.ItemListUserBinding
import com.yumtaufikhidayat.gitser.ui.activity.DetailActivity

class UserAdapter(private val listUser: ArrayList<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        return ViewHolder(
            ItemListUserBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size

    inner class ViewHolder(private val binding: ItemListUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(user.profileImage)
                    .apply(RequestOptions().override(55, 55))
                    .into(imgProfilePhoto)

                tvUsername.text = user.username
                tvName.text = user.profileName
                tvUserFollowing.text = user.following.toString()
                tvUserFollowers.text = user.followers.toString()
                tvUserRepositories.text = user.repositories.toString()
                tvUserLocation.text = user.location
                tvUserOffice.text = user.office

                constraintItemUser.setOnClickListener {
                    it.context.startActivity(
                        Intent(itemView.context, DetailActivity::class.java).apply {
                            putExtra(DetailActivity.EXTRA_PARCELABLE, user)
                    })
                }
            }
        }
    }
}