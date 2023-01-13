package com.example.android.unscramble.ui.game

import androidx.lifecycle.ViewModel
import java.lang.reflect.Array.get

class GameViewModel :  ViewModel() {
    private var _score = 0
    private var _currentWordCount = 0
    private var _currentScrambledWord = "test"

    val currentScrambledWord:String
        get() = _currentScrambledWord

}