package com.practice.exmaple

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var point: Int = 0,
) {
    fun decreasePoint(amount: Int) {
        require(point >= amount) {
            throw BusinessException(ErrorCode.INSUFFICIENT_POINT, point, amount)
        }
        point -= amount
    }

    fun increasePoint(amount: Int) {
        point += amount
    }
}