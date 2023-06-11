package com.wertnExamlpe.foodApplication.service

import com.wertnExamlpe.foodApplication.datasource.FoodDataSource
import com.wertnExamlpe.foodApplication.model.Food
import org.springframework.stereotype.Service

@Service
class FoodService(private val dataSource: FoodDataSource) {

    fun getFoods(): Collection<Food> = dataSource.retrieveFoods()

    fun getFood(id: Int) = dataSource.retrieveFood(id)

    fun addFood(food: Food): Food = dataSource.createFood(food)

    fun updateFood(food: Food): Food = dataSource.updateFood(food)

    fun deleteFood(id: Int): Unit = dataSource.deleteFood(id)
}