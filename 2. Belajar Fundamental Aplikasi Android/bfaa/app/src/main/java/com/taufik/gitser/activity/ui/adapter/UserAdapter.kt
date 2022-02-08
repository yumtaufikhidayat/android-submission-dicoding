package com.taufik.gitser.activity.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.taufik.gitser.activity.data.User
import com.taufik.gitser.databinding.ItemListUserBinding

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
                    Toast.makeText(itemView.context, user.username, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}