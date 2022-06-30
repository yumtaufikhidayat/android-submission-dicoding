package com.yumtaufikhidayat.gitser.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.yumtaufikhidayat.gitser.data.local.FavoriteEntity

class BaseDiffCallback(
    private val mOldList: List<FavoriteEntity>,
    private val mNewList: List<FavoriteEntity>,
) : DiffUtil.Callback(){
    override fun getOldListSize(): Int = mOldList.size

    override fun getNewListSize(): Int = mNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldList[oldItemPosition].id == mNewList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = mOldList[oldItemPosition]
        val new = mNewList[oldItemPosition]
        return old.id == new.id && old.login == new.login
    }
}