package com.rohan.dsaprime

// Wrapper to hold conditional state
class ThenElse<T>(private val condition: Boolean, private val thenValue: T) {
    infix fun otherWise (elseValue: T): T {
        return if (condition) thenValue else elseValue
    }
}

// Extension function on Boolean
infix fun <T> Boolean.then(value: T): ThenElse<T> {
    return ThenElse(this, value)
}