package com.digi.composecalculator.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyViewModel : ViewModel() {

    // state handling
    private val _uiState = MutableStateFlow(MyUiState())
    val uiState: StateFlow<MyUiState> = _uiState.asStateFlow()

    fun onEvent(event: MyEvent) {
        // event handling
        when (event) {
            MyEvent.OnAddClicked -> addNums()
            MyEvent.OnSubClicked -> subNums()
            MyEvent.OnMulClicked -> mulNums()
            MyEvent.OnDivClicked -> divNums()
            is MyEvent.OnNum1Entered -> _uiState.update { it.copy(num1 = event.num1) }
            is MyEvent.OnNum2Entered -> _uiState.update { it.copy(num2 = event.num2) }
            MyEvent.OnClearClicked -> _uiState.update { it.copy(num1 = "", num2 = "", ans = "") }
        }
    }

    private fun divNums() {
        val n1 = _uiState.value.num1.toInt()
        val n2 = _uiState.value.num2.toInt()
        val ans = n1 / n2
        _uiState.update { it.copy(ans = ans.toString()) }
    }

    private fun mulNums() {
        val n1 = _uiState.value.num1.toInt()
        val n2 = _uiState.value.num2.toInt()
        val ans = n1 * n2
        _uiState.update { it.copy(ans = ans.toString()) }
    }

    private fun subNums() {
        val n1 = _uiState.value.num1.toInt()
        val n2 = _uiState.value.num2.toInt()
        val ans = n1 - n2
        _uiState.update { it.copy(ans = ans.toString()) }
    }

    private fun addNums() {
        val n1 = _uiState.value.num1.toInt()
        val n2 = _uiState.value.num2.toInt()
        val ans = n1 + n2
        _uiState.update { it.copy(ans = ans.toString()) }
    }

}