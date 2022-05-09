package com.yumtaufikhidayat.gitser.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.yumtaufikhidayat.gitser.data.response.search.Search
import com.yumtaufikhidayat.gitser.databinding.ItemListUserBinding
import com.yumtaufikhidayat.gitser.utils.Utils.loadImage

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val listUser = ArrayList<Search>()

    fun setSearchUserList(searches: ArrayList<Search>) {
        listUser.clear()
        listUser.addAll(searches)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        return UserViewHolder(
            ItemListUserBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        )
    }

    override fun onBindViewHolder(
        holder: UserAdapter.UserViewHolder,
        position: Int
    ) = holder.bind(listUser[position])

    override fun getItemCount(): Int = listUser.size

    inner class UserViewHolder(private val binding: ItemListUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(search: Search) {
            binding.apply {
                imgProfilePhoto.loadImage(search.avatarUrl)
                tvUsername.text = search.login
                tvProfileType.text = search.type

                constraintItemUser.setOnClickListener {
//                    it.context.startActivity(
//                        Intent(itemView.context, DetailActivity::class.java).apply {
//                            putExtra(DetailActivity.EXTRA_PARCELABLE, search)
//                        })
                    Toast.makeText(itemView.context, search.login, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}