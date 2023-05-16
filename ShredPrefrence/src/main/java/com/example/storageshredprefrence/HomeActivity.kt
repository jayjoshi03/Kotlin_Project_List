package com.example.storageshredprefrence

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.storageshredprefrence.adapter.UserListAdapter
import com.example.storageshredprefrence.databinding.ActivityHomeBinding
import com.example.storageshredprefrence.model.User
import com.example.storageshredprefrence.prefrences.PreManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var listAdapter: UserListAdapter
    private var user = mutableListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        user.add(User(1,"Jay","Jay@gmail.com","8849728739"))
        user.add(User(2,"Nigam","Nigam@gmail.com","9106719379"))



        listAdapter = UserListAdapter(this,user)
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = listAdapter

//        binding.btnLogout.setOnClickListener {
//            val manager = PreManager(this)
//            manager.logout()
//
//            // navigate to login activity
//            startActivity(Intent(this, LoginActivity::class.java))
//        }

        binding.topAppBar.setOnMenuItemClickListener {menuItems ->
            when(menuItems.itemId){
                R.id.btn_logout -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Logout")
                        .setMessage("Are You Sure?")
                        .setPositiveButton("Logout",DialogInterface.OnClickListener { dialogInterface, i ->
                            val manager = PreManager(this)
                            manager.logout()

                            // navigate to login activity
                            startActivity(Intent(this, LoginActivity::class.java))
                        })
                        .setNegativeButton("Cancel",DialogInterface.OnClickListener { dialogInterface, i ->

                        })
                        .show()
                    true
                }
                else -> false
            }
        }


    }
}