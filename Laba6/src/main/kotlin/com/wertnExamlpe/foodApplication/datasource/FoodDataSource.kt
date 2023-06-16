package com.wertnExamlpe.foodApplication.datasource

import com.wertnExamlpe.foodApplication.model.Food

interface FoodDataSource {
    fun retrieveFoods(): Collection<Food>

    fun retrieveFood(id: Int): Food

    fun createFood(food: Food): Food

    fun updateFood(food: Food): Food

    fun deleteFood(id: Int): Unit
}