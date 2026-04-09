package com.practice.exmaple

import org.springframework.stereotype.Component

@Component
class UserReader(
    private val userRepository: UserRepository,
) {
    fun getWithLock(id: Long): User =
        userRepository.findByIdWithLock(id)
            .orElseThrow { BusinessException(ErrorCode.USER_NOT_FOUND, id) }
}