package com.tdmnsExamlpe.FoodApplication.service

import com.wertnExamlpe.foodApplication.datasource.FoodDataSource
import com.wertnExamlpe.foodApplication.service.FoodService
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class FoodServiceTest {

    private val dataSource: FoodDataSource = mockk(relaxed = true)
    private val foodService = FoodService(dataSource)

    @Test
    fun `should call its data source to retrieve foods`() {
        // when
        foodService.getFoods()

        // then
        verify(exactly = 1) { dataSource.retrieveFoods() }
    } 
}