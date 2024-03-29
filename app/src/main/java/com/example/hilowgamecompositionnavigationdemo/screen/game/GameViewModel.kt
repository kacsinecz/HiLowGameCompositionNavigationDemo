package com.example.hilowgamecompositionnavigationdemo.screen.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    var generatedNum by mutableStateOf(0)
    var upperBound by mutableStateOf(11)
    var counter by mutableStateOf(0)
    var numberText by mutableStateOf("")
    var textResult by mutableStateOf("-")
    var inputErrorState by mutableStateOf(false)
    var showWinDialog by mutableStateOf(false)

    fun validate(text_result:String) {
        val allDigit = numberText.all { char -> char.isDigit() }
        textResult = text_result
        inputErrorState = !allDigit
    }

    init {
        savedStateHandle.get<Int>("upperBound")?.let {
            upperBound = it;
        }
        generateNewNum()
    }

    fun generateNewNum() {
        generatedNum = Random(System.currentTimeMillis()).nextInt(upperBound)
        counter = 0
    }

    fun increaseCounter() {
        counter++
    }
}