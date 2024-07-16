package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.test.ui.screen.ComponentsCompose
import com.example.test.ui.screen.ConstraintExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            TestPreview()
            ComponentsCompose()
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
//    ShowText("Example")
    ConstraintExample()

}







