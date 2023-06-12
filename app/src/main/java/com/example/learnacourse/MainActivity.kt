package com.example.learnacourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.learnacourse.presentation.LearnACourse
import com.example.learnacourse.ui.theme.LearnACourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnACourseTheme {
                // A surface container using the 'background' color from the theme

                LearnACourse()
            }
        }
    }
}

