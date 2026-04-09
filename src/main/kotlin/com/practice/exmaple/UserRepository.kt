package com.practice.exmaple

import jakarta.persistence.LockModeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface UserRepository : JpaRepository<User, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select u from User u where u.id = :id")
    fun findByIdWithLock(id: Long): Optional<User>
}