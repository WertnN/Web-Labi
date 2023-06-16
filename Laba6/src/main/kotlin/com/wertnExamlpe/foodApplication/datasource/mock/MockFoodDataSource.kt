package com.wertnExamlpe.foodApplication.datasource.mock

import com.wertnExamlpe.foodApplication.datasource.FoodDataSource
import com.wertnExamlpe.foodApplication.model.Food
import org.springframework.stereotype.Repository


@Repository
class MockFoodDataSource: FoodDataSource {

    val foods = mutableListOf(
        Food(1, "Помидор", "Очень вкусна не поверишь.","Салат"),
        Food(2, "Кукуруза", "Сладкая и вкусная","Салат"),
        Food(3, "Капуста", "Полезная и много применяемая", "Голубцы")
    )

    override fun retrieveFoods(): Collection<Food> = foods

    override fun retrieveFood(id: Int): Food = foods.firstOrNull() { it.id == id }
        ?: throw NoSuchElementException("Could not find a food with account number $id")

    override fun createFood(food: Food): Food {
        if (foods.any {it.id == food.id}) {
            throw IllegalArgumentException("Food with account number ${food.id} already exist")
        }
        foods.add(food)
        return food
    }

    override fun updateFood(food: Food): Food {
        val currentFood = foods.firstOrNull() { it.id == food.id }
            ?: throw NoSuchElementException("Could not find a food with account number ${food.id}")

        foods.remove(currentFood)
        foods.add(food)

        return food
    }

   override fun deleteFood(id: Int) {
        val currentFood = foods.firstOrNull() { it.id == id }
            ?: throw NoSuchElementException("Could not find a food with account number $id")

        foods.remove(currentFood)
    }
}