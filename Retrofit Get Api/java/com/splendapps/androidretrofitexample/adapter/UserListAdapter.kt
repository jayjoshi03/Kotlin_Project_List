package com.splendapps.androidretrofitexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.splendapps.androidretrofitexample.R
import com.splendapps.androidretrofitexample.databinding.ItemUserLayoutBinding
import com.splendapps.androidretrofitexample.model.User

class UserListAdapter(var context: Context, var userList: MutableList<User>) :
    RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {

    lateinit var binding: ItemUserLayoutBinding

    class MyViewHolder(var binding: ItemUserLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemUserLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var user = userList[position]
        holder.binding.tvName.text = "${user.firstName} ${user.lastName}"
        holder.binding.tvEmail.text = "${user.email}"

        Glide
            .with(context)
            .load(user.avatar)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.binding.ivThumbnail)

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setItems(userList: MutableList<User>){
        this.userList = userList
        notifyDataSetChanged()
    }

}