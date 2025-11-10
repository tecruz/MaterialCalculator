package com.tecruz.materialcalculator.domain

class ExpressionWriter {
    var expression = ""

    fun processAction(action: CalculatorAction) {
        when (action) {
            CalculatorAction.Calculate -> {
                val parser = ExpressionParser(prepareForCalculation())
                val evaluator = ExpressionEvaluator(parser.parse())
                expression = evaluator.evaluate().toString()
            }
            CalculatorAction.Clear -> {
                expression = ""
            }
            CalculatorAction.Decimal -> {
                if (canEnterDecimal()) {
                    expression += "."
                }
            }
            CalculatorAction.Delete -> {
                expression = expression.dropLast(1)
            }
            is CalculatorAction.Number -> {
                expression += action.number
            }
            is CalculatorAction.Op -> {
                val operation = action.operation
                when {
                    expression.last() in operationSymbols -> {
                        // Replace the last operator, but not a unary + or - at the start
                        if (expression.length > 1) {
                            expression = expression.dropLast(1) + operation.symbol
                        }
                    }
                    expression.isEmpty() || expression.last() == '(' -> {
                        if (operation in listOf(Operation.ADD, Operation.SUBTRACT)) {
                            expression += operation.symbol
                        }
                    }
                    else -> {
                        expression += operation.symbol
                    }
                }
            }
            CalculatorAction.Parentheses -> {
                processParentheses()
            }
        }
    }

    private fun prepareForCalculation(): String {
        val newExpression =
            expression.dropLastWhile {
                it in "$operationSymbols(."
            }
        if (newExpression.isEmpty()) {
            return "0"
        }
        return newExpression
    }

    private fun processParentheses() {
        val openingCount = expression.count { it == '(' }
        val closingCount = expression.count { it == ')' }
        expression +=
            when {
                expression.isEmpty() ||
                    expression.last() in "$operationSymbols(" -> "("
                expression.last() in "0123456789)" &&
                    openingCount == closingCount -> return
                else -> ")"
            }
    }

    private fun canEnterDecimal(): Boolean {
        if (expression.isEmpty() || expression.last() in "$operationSymbols.()") {
            return false
        }
        return !expression.takeLastWhile {
            it in "0123456789."
        }.contains(".")
    }
}