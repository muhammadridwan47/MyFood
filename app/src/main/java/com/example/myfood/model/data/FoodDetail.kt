package com.example.myfood.model.data


data class FoodDetail(var foodId: String = "",var name: String = "", var price: String = "", var typicalFood:String = "", var description: String = "",var taste: Float = 0f, var rating: Float = 0f, var image: Int = 0, var ingredients: String, var otherFoods: List<OtherFoods>)
