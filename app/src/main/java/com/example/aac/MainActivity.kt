package com.example.aac

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.aac.data.Word
import com.example.aac.data.WordViewModel
import com.example.aac.data.WordViewModelFactory
import com.example.aac.data.WordsApplication
import com.example.aac.ui.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.pager)
        val adapter = PageAdapter(this)
        adapter.addFragment(Fragment1(), "Fragment 1")
        adapter.addFragment(Fragment2(), "Fragment 2")
        adapter.addFragment(Fragment3(), "Fragment 3")

        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.text = adapter.getFragmentTitle(position)
        }.attach()
    }
}