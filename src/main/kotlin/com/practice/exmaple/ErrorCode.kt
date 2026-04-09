package com.practice.exmaple

enum class ErrorCode(val message: String) {
    USER_NOT_FOUND("사용자를 찾을 수 없습니다. (ID: %d)"),
    INSUFFICIENT_POINT("잔액이 부족합니다. (현재: %d, 요청: %d)"),
}