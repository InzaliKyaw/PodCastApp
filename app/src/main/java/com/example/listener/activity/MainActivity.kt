package com.example.listener.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.listener.R
import com.example.listener.fragments.HomeFragment
import com.example.listener.fragments.ProfileFragment
import com.example.listener.fragments.SearchFragment
import com.example.listener.fragments.YourShowsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if (savedInstanceState == null) {
//            // 2
//            supportFragmentManager
//                // 3
//                .beginTransaction()
//                // 4
//                .add(R.id.root_layout, DogListFragment.newInstance(), "dogList")
//                // 5
//                .commit()
//        }
        bottomNavigaton.setOnNavigationItemSelectedListener (object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.home ->{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameContainerNavigation, HomeFragment.newInstance())
                            .commit()

                    }
                    R.id.yourShow->{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameContainerNavigation,YourShowsFragment())
                            .commit()
                    }
                    R.id.search ->{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameContainerNavigation,SearchFragment())
                            .commit()
                    }
                    R.id.profile ->{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameContainerNavigation,ProfileFragment())
                            .commit()
                    }
                }
                return false

            }
        })

    }
}