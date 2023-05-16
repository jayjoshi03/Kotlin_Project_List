package com.example.storageshredprefrence.adapter

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.storageshredprefrence.LoginActivity
import com.example.storageshredprefrence.databinding.UserCardBinding
import com.example.storageshredprefrence.model.User
import com.example.storageshredprefrence.prefrences.PreManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class UserListAdapter(var context: Context, var userList:MutableList<User>):RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {
    lateinit var binding: UserCardBinding
    class MyViewHolder(var binding: UserCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = UserCardBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.ivName.text = user.name
        holder.binding.ivEmail.text = user.email
        holder.binding.ivContact.text = user.contact

        holder.binding.cardView.setOnLongClickListener {
            MaterialAlertDialogBuilder(context)
                .setTitle("Delete")
                .setMessage("Are You Sure?")
                .setPositiveButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->
                  notifyItemRemoved(position) //remove adapter
                  userList.removeAt(position)
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->

                })
                .show()
            return@setOnLongClickListener true
        }
    }
}