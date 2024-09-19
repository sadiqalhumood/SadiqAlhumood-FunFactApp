package com.example.funfact
import com.example.funfact.ui.theme.FunFactTheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FunFactTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        FunFact()
                    }
                }
            }
        }
    }
}

@Composable
fun FunFact() {
    val factList = listOf("Avocados are a fruit, not a vegetable.",
        "Baby rabbits are called kits.",
        "Australia is wider than the moon.",
        "Human teeth are the only part of the body that cannot heal themselves.",
        "The heart of a shrimp is located in its head.",
        "In 2014, there was a Tinder match in Antarctica.",
        "Q is the only letter that doesn’t appear in any American state name.",
        "The moon has moonquakes.",
        "Vatican City is the smallest country in the world.",
        "The Eiffel Tower was originally intended for Barcelona.")


    var currentIndex by remember { mutableStateOf(0) }

    var i = 0
    var v = 0



    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Fun Fact")

        Text(
            text = "\"${factList[currentIndex]}\"",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = Modifier.padding(16.dp),
            color = Color(0xFF003366)
        )

        Button(
            onClick = {
                currentIndex = (currentIndex + 1) % factList.size
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF82CAFF),
                contentColor = Color(0xFF000000)
            ),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Next Fun Fact")
        }

        Spacer(modifier = Modifier.padding(12.dp))
        Text("${currentIndex + 1} / ${factList.size}")
    }
}