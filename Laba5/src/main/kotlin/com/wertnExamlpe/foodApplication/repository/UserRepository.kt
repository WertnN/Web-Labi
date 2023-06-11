package com.wertnExamlpe.foodApplication.repository

import com.wertnExamlpe.foodApplication.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int> {
    fun findByEmail(email: String): User?
}
