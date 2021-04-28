package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.focus.isFocused
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.ui.theme.ComposefocusmodifierbugTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposefocusmodifierbugTheme {
                // A surface container using the 'background' color from the theme
                Column {
                    Text("Use arrows to move focus over the following items:")
                    BoxWithFocusModifiersInGoodOrder()
                    BoxWithFocusModifiersInFaultyOrder()
                    BoxWithFocusModifiersInGoodOrder()
                    BoxWithFocusModifiersInFaultyOrder()
                }
            }
        }
    }

    @Composable
    private fun BoxWithFocusModifiersInGoodOrder() {
        var color by remember { mutableStateOf(Color.Yellow) }
        Box(modifier = Modifier
            .onFocusChanged {
                color = if (it.isFocused) Color.Red else Color.Blue
            }
            .focusModifier()
            .background(color)
        ) {
            Text (text = "onFocusChanged is invoked", style = TextStyle(Color.White))
        }
    }

    @Composable
    private fun BoxWithFocusModifiersInFaultyOrder() {
        var color by remember { mutableStateOf(Color.Yellow) }
        Box(modifier = Modifier
            .focusModifier()
            .onFocusChanged {
                color = if (it.isFocused) Color.Red else Color.Blue
            }
            .background(color)
        ) {
            Text("onFocusChanged is NOT invoked", style = TextStyle(Color.White))
        }
    }
}