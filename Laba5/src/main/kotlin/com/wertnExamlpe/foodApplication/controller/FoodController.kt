package com.wertnExamlpe.foodApplication.controller

import com.wertnExamlpe.foodApplication.model.Food
import com.wertnExamlpe.foodApplication.service.FoodService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/foods")
class FoodController(private val service: FoodService) {
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    fun getFoods(): Collection<Food> = service.getFoods()


    @GetMapping("/{id}")
    fun getFood(@PathVariable id: Int): Food = service.getFood(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addFood(@RequestBody food: Food): Food = service.addFood(food)

    @PatchMapping
    fun updateFood(@RequestBody food: Food): Food = service.updateFood(food)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteFood(@PathVariable id: Int): Unit = service.deleteFood(id)
}