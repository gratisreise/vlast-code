package com.practice.exmaple

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PointService(
    private val userReader: UserReader,
) {
    @Transactional
    fun transferPoint(fromUserId: Long, toUserId: Long, amount: Int) {
        // 1. 데드락 방지를 위한 정렬
        val firstId = minOf(fromUserId, toUserId)
        val secondId = maxOf(fromUserId, toUserId)

        // 2. 일관된 순서로 비관적 락 획득
        val first = userReader.getWithLock(firstId)
        val second = userReader.getWithLock(secondId)

        // 3. 실제 비즈니스 주체 매핑
        val from = if (first.id == fromUserId) first else second
        val to = if (first.id == toUserId) first else second

        // 4. 도메인 객체에 로직 위임 (Tell, Don't Ask)
        from.decreasePoint(amount)
        to.increasePoint(amount)
    }
}