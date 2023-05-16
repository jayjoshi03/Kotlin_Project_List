package com.splendapps.navigationdrawerandroid

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.splendapps.navigationdrawerandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.layoutAppBar.toolBar.title = "Home"
        setSupportActionBar(binding.layoutAppBar.toolBar)

        drawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.layoutAppBar.toolBar,
            R.string.nav_open,
            R.string.nav_close
        )

        // to toggle the button
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        addFragment(HomeFragment(), "Home")

        // to make the Navigation drawer icon always appear on the action bar
        //supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.navigationView.setNavigationItemSelectedListener {
            return@setNavigationItemSelectedListener when (it.itemId) {
                R.id.nav_home -> {
                    addFragment(HomeFragment(), "Home")
                    true
                }
                R.id.nav_profile -> {
                    addFragment(ProfileFragment(), "Profile")
                    true
                }
                R.id.nav_order -> {
                    true
                }
                R.id.nav_notification -> {
                    true
                }
                R.id.nav_settings -> {
                    true
                }
                R.id.nav_policy -> {
                    true
                }
                R.id.nav_logout -> {
                    true
                }
                else -> false
            }
        }

    }

    private fun addFragment(fragment: Fragment, title: String) {
        var manager = supportFragmentManager
        var transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(title)
        transaction.commit()

        binding.layoutAppBar.toolBar.title = "$title"
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }
}