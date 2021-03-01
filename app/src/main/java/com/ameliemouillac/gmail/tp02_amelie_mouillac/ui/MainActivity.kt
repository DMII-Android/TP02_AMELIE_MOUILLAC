package com.ameliemouillac.gmail.tp02_amelie_mouillac.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ameliemouillac.gmail.tp02_amelie_mouillac.NavigationListener
import com.ameliemouillac.gmail.tp02_amelie_mouillac.R
import com.ameliemouillac.gmail.tp02_amelie_mouillac.databinding.ActivityMainBinding
import com.ameliemouillac.gmail.tp02_amelie_mouillac.ui.fragments.ListNeighborsFragment

class MainActivity : AppCompatActivity(), NavigationListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        showFragment(ListNeighborsFragment())
        updateTitle(R.string.list_fragment_title)
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

    override fun updateTitle(title: Int) {
        binding.toolbar.setTitle(title)
    }
}