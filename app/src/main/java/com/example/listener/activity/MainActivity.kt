package com.example.listener.activity

import android.os.Bundle
import android.view.MenuItem
import com.example.listener.R
import com.example.listener.fragments.HomeFragment
import com.example.listener.fragments.ProfileFragment
import com.example.listener.fragments.SearchFragment
import com.example.listener.fragments.YourShowsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainerNavigation, HomeFragment.newInstance())
            .commit()

        bottomNavigaton.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameContainerNavigation, HomeFragment.newInstance())
                            .commit()

                    }

                    R.id.search -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameContainerNavigation, SearchFragment.newInstance())
                            .commit()
                    }
                    R.id.yourShow -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameContainerNavigation, YourShowsFragment())
                            .commit()
                    }
                    R.id.profile -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameContainerNavigation, ProfileFragment())
                            .commit()
                    }
                }
                return true

            }
        })

    }
}