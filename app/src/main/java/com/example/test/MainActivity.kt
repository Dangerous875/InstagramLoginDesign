package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestPreview()
        }
    }
}

@Preview(
    name = "test",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 34,
    device = Devices.PIXEL_3A
)
@Composable
fun TestPreview() {
    ShowText("Example")
}

@Composable
fun ShowText(name: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(color = Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "$name 1")
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(color = Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "$name 2")
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(color = Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "$name 3")
            }

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(color = Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "$name 4")
        }
    }
}



