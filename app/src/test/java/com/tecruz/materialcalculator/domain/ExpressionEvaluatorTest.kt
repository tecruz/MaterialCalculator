package com.tecruz.materialcalculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionEvaluatorTest {
    private lateinit var evaluator: ExpressionEvaluator

    @Test
    fun `Simple expression properly evaluated`() {
        evaluator =
            ExpressionEvaluator(
                listOf(
                    ExpressionPart.Number(4.0),
                    ExpressionPart.Op(Operation.ADD),
                    ExpressionPart.Number(5.0),
                    ExpressionPart.Op(Operation.SUBTRACT),
                    ExpressionPart.Number(3.0),
                    ExpressionPart.Op(Operation.MULTIPLY),
                    ExpressionPart.Number(5.0),
                    ExpressionPart.Op(Operation.DIVIDE),
                    ExpressionPart.Number(3.0),
                ),
            )

        assertThat(evaluator.evaluate()).isEqualTo(4.0)
    }

    @Test
    fun `Expression with decimals properly evaluated`() {
        evaluator =
            ExpressionEvaluator(
                listOf(
                    ExpressionPart.Number(4.5),
                    ExpressionPart.Op(Operation.ADD),
                    ExpressionPart.Number(5.5),
                    ExpressionPart.Op(Operation.SUBTRACT),
                    ExpressionPart.Number(3.5),
                    ExpressionPart.Op(Operation.MULTIPLY),
                    ExpressionPart.Number(5.5),
                    ExpressionPart.Op(Operation.DIVIDE),
                    ExpressionPart.Number(3.5),
                ),
            )

        assertThat(evaluator.evaluate()).isEqualTo(4.5)
    }

    @Test
    fun `Simple equation with parentheses properly evaluated`() {
        evaluator =
            ExpressionEvaluator(
                listOf(
                    ExpressionPart.Number(4.0),
                    ExpressionPart.Op(Operation.ADD),
                    ExpressionPart.Parentheses(ParenthesesType.Opening),
                    ExpressionPart.Number(5.0),
                    ExpressionPart.Op(Operation.SUBTRACT),
                    ExpressionPart.Number(3.0),
                    ExpressionPart.Parentheses(ParenthesesType.Closing),
                    ExpressionPart.Op(Operation.MULTIPLY),
                    ExpressionPart.Number(5.0),
                    ExpressionPart.Op(Operation.DIVIDE),
                    ExpressionPart.Number(4.0),
                ),
            )

        assertThat(evaluator.evaluate()).isEqualTo(6.5)
    }

    @Test
    fun `Expression with nested parentheses is properly evaluated`() {
        evaluator =
            ExpressionEvaluator(
                listOf(
                    ExpressionPart.Parentheses(ParenthesesType.Opening),
                    ExpressionPart.Number(4.0),
                    ExpressionPart.Op(Operation.ADD),
                    ExpressionPart.Parentheses(ParenthesesType.Opening),
                    ExpressionPart.Number(5.0),
                    ExpressionPart.Op(Operation.SUBTRACT),
                    ExpressionPart.Number(3.0),
                    ExpressionPart.Parentheses(ParenthesesType.Closing),
                    ExpressionPart.Parentheses(ParenthesesType.Closing),
                    ExpressionPart.Op(Operation.MULTIPLY),
                    ExpressionPart.Number(2.0),
                ),
            )
        assertThat(evaluator.evaluate()).isEqualTo(12.0)
    }

    @Test
    fun `Expression with unary minus is properly evaluated`() {
        evaluator =
            ExpressionEvaluator(
                listOf(
                    ExpressionPart.Op(Operation.SUBTRACT),
                    ExpressionPart.Number(5.0),
                    ExpressionPart.Op(Operation.ADD),
                    ExpressionPart.Number(3.0),
                ),
            )
        assertThat(evaluator.evaluate()).isEqualTo(-2.0)
    }

    @Test
    fun `Percentage operator is properly evaluated`() {
        evaluator =
            ExpressionEvaluator(
                listOf(
                    ExpressionPart.Number(100.0),
                    ExpressionPart.Op(Operation.PERCENT),
                    ExpressionPart.Number(50.0),
                ),
            )
        // Note: The current implementation evaluates 'a % b' as 'a * (b / 100)'
        assertThat(evaluator.evaluate()).isEqualTo(50.0)
    }
}
