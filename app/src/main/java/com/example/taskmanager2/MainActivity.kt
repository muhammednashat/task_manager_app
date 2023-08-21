package com.example.taskmanager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val mainFragment = MainFragment()
        val chatRoomFragment = ChatRoomFragment()
        val profileFragment = ProfileFragment()

        setCurrentFragment(mainFragment)
        findViewById<BottomNavigationView>(R.id.bottom_nav).setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_item_home -> setCurrentFragment(mainFragment)
                R.id.menu_item_chat -> setCurrentFragment(chatRoomFragment)
                R.id.menu_item_profile -> setCurrentFragment(profileFragment)
            }
            true
        }

    }


    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout,fragment)
            commit()
        }
    }
}