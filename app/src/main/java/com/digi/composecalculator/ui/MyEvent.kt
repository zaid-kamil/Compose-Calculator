package com.digi.composecalculator.ui

sealed interface MyEvent{
    object OnAddClicked: MyEvent
    object OnDivClicked: MyEvent
    object OnSubClicked: MyEvent
    object OnMulClicked: MyEvent
    object OnClearClicked: MyEvent
    data class OnNum1Entered(val num1: String): MyEvent
    data class OnNum2Entered(val num2: String): MyEvent
}