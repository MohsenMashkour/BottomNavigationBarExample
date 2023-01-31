package com.mkrdeveloper.bottomnavigationbarexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        val homeFragment = HomeFragment()
        val hotelFragment = HotelFragment()
        val ticketFragment = TicketFragment()


        setFragment(homeFragment)


        navView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> {setFragment(homeFragment)
                }

                R.id.hotel -> {setFragment(hotelFragment)}
                R.id.ticket -> {setFragment(ticketFragment)}
                R.id.restaurants -> {
                    Toast.makeText(this, "restaurant selected", Toast.LENGTH_SHORT).show()}
                R.id.city_map -> {
                    Toast.makeText(this, "Map selected", Toast.LENGTH_SHORT).show()}
            }
            true
        }

    }

    private fun setFragment(fragment: Fragment) {


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }

    }
}