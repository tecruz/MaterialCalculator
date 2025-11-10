package com.tecruz.materialcalculator.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tecruz.materialcalculator.MainActivity
import org.junit.Rule
import org.junit.Test

class CalculatorScreenTest {
    @get:Rule
    val composeRule = createAndroidComposeRule(MainActivity::class.java)

    @Test
    fun enterExpression_correctResultDisplayed() {
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("2").performClick()
        composeRule.onNodeWithText("x").performClick()
        composeRule.onNodeWithText("3").performClick()
        composeRule.onNodeWithText("-").performClick()
        composeRule.onNodeWithText("5").performClick()
        composeRule.onNodeWithText("=").performClick()

        composeRule.onNodeWithText("2.0").assertIsDisplayed()
    }

    @Test
    fun enterExpressionWithParentheses_correctResultDisplayed() {
        composeRule.onNodeWithText("()").performClick()
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("2").performClick()
        composeRule.onNodeWithText("()").performClick()
        composeRule.onNodeWithText("x").performClick()
        composeRule.onNodeWithText("3").performClick()
        composeRule.onNodeWithText("=").performClick()

        composeRule.onNodeWithText("9.0").assertIsDisplayed()
    }

    @Test
    fun clearExpression_expressionIsCleared() {
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("2").performClick()

        composeRule.onNodeWithText("AC").performClick()

        composeRule.onNodeWithText("").assertIsDisplayed()
    }

    @Test
    fun divideByZero_showsError() {
        composeRule.onNodeWithText("5").performClick()
        composeRule.onNodeWithText("÷").performClick()
        composeRule.onNodeWithText("0").performClick()
        composeRule.onNodeWithText("=").performClick()

        composeRule.onNodeWithText("Infinity").assertIsDisplayed()
    }
}
