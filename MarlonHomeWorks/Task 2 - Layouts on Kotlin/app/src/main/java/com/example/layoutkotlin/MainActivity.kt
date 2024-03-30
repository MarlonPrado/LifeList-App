package com.example.layoutkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.layoutkotlin.ui.theme.LayoutKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutKotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPreview()
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String,message2: String,message3: String, modifier: Modifier = Modifier) {
        Column{
            Image(painter = painterResource(id = R.drawable.images), contentDescription = message)
            Text(
                text = message2,
                fontSize = 40.sp,
                lineHeight = 108.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = message3,
                fontSize = 60.sp,
                lineHeight = 108.sp,
                textAlign = TextAlign.Right
            )

        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LayoutKotlinTheme {
        GreetingText("A Silly cat","Hi everyone","Look a cat! Cool !!")
    }
}