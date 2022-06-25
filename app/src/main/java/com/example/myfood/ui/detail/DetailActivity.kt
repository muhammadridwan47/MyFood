package com.example.myfood.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfood.R
import com.example.myfood.model.data.FoodDetail
import com.example.myfood.ui.home.HomeActivity.Companion.key_intent

class DetailActivity : AppCompatActivity() {
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var rvList: RecyclerView
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        rvList = findViewById(R.id.rv_horizontal)
        toolbar = findViewById(R.id.toolbar)

        toolbarBack()
        getData()

        viewModel._data.observe(this) {
            setDataToView(it)
        }
    }

    private fun getData() {
        val value  = intent.getStringExtra(key_intent)
        viewModel.getFood(value!!)
    }

    private fun getDataByItem(foodId: String) {
        viewModel.getFood(foodId)
    }

    private fun setDataToView(data: FoodDetail) {
        val imgDetail: ImageView = findViewById(R.id.imgDetail)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvPrice: TextView = findViewById(R.id.tv_price)
        val tvTypicalFood: TextView = findViewById(R.id.tv_typical_food)
        val ratingTaste: RatingBar = findViewById(R.id.rating_bar_taste)
        val rating: RatingBar = findViewById(R.id.rating)
        val ingredient: TextView = findViewById(R.id.tv_ingredient)
        val description: TextView = findViewById(R.id.tv_description)

        tvName.text = data.name
        tvPrice.text = data.price
        tvTypicalFood.text = data.typicalFood
        ratingTaste.rating = data.taste
        rating.rating = data.rating
        ingredient.text = data.ingredients
        description.text = data.description

        rvList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val horizontalListAdapter = HorizontalList(data.otherFoods)
        rvList.adapter = horizontalListAdapter
        horizontalListAdapter.setOnItemClickCallback (object : HorizontalList.OnItemClickCallback{
            override fun onItemClicked(foodId: String) {
                getDataByItem(foodId)
            }
        })
        Glide.with(this)
            .load(data.image)
            .into(imgDetail)
    }

    private fun toolbarBack() {
        toolbar.visibility = View.VISIBLE
        toolbar.setNavigationOnClickListener {onBackPressed()}
    }
}