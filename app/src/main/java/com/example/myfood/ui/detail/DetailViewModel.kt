package com.example.myfood.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfood.model.data.FoodDetail
import com.example.myfood.model.dummy.FoodData

class DetailViewModel: ViewModel() {
    private var data = MutableLiveData<FoodDetail>();
    val _data : LiveData<FoodDetail> = data;

    fun getFood(foodId: String){
        val index = FoodData.foods.indexOfFirst{
            it.foodId == foodId
        }
        data.value = FoodData.foods[index]
    }
}