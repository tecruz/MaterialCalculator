package com.tecruz.materialcalculator.domain

enum class Operation(val symbol: Char) {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('x'),
    DIVIDE('/'),
    PERCENT('%'),
}

val operationSymbols = Operation.entries.map { it.symbol }.joinToString("")

fun operationFromSymbol(symbol: Char): Operation =
    Operation.entries.find { it.symbol == symbol }
        ?: throw IllegalArgumentException("Invalid symbol")