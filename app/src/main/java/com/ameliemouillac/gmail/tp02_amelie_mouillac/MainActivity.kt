package com.ameliemouillac.gmail.tp02_amelie_mouillac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ameliemouillac.gmail.tp02_amelie_mouillac.databinding.ActivityMainBinding
import com.ameliemouillac.gmail.tp02_amelie_mouillac.databinding.ListNeighborsFragmentBinding
import com.ameliemouillac.gmail.tp02_amelie_mouillac.fragments.AddNeighbourFragment
import com.ameliemouillac.gmail.tp02_amelie_mouillac.fragments.ListNeighborsFragment

class MainActivity : AppCompatActivity(), NavigationListener {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        changeFragment(ListNeighborsFragment())
    }

    fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }

    override fun showFragment(fragment: Fragment) {
        changeFragment(fragment)
    }
}