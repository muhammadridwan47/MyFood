package com.example.myfood.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfood.R
import com.example.myfood.model.data.ListFood
import com.example.myfood.model.dummy.FoodData
import com.example.myfood.ui.detail.DetailActivity
import com.example.myfood.ui.profile.ProfileActivity
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timerTask

class HomeActivity : AppCompatActivity() {
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var rvList: RecyclerView

    companion object {
        const val key_intent = "foodId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        toolbar = findViewById(R.id.toolbar)
        rvList = findViewById(R.id.rv_list_home)
        toolbarProfile()
        showRecyclerList(FoodData.listData)
    }

    private fun showRecyclerList(list: ArrayList<ListFood>) {
        rvList.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListAdapter(list)
        rvList.adapter = listAdapter
        listAdapter.setOnItemClickCallback (object : ListAdapter.OnItemClickCallback{
            override fun onItemClicked(data: ListFood) {
                goToDetailActivity(data.foodId)
            }
        })
    }

    private fun toolbarProfile() {
        toolbar.visibility = View.VISIBLE
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_person,null)
        toolbar.layoutDirection = View.LAYOUT_DIRECTION_RTL
        toolbar.setNavigationOnClickListener {
            goToProfileActivity()
        }
    }

    private fun goToProfileActivity(){
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
    }

    private fun goToDetailActivity(foodId: String){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(key_intent, foodId )
        startActivity(intent)
    }

}