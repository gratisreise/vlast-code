package com.practice.exmaple

class BusinessException(
    val errorCode: ErrorCode,
    vararg args: Any?,
) : RuntimeException(if (args.isEmpty()) errorCode.message else errorCode.message.format(*args))