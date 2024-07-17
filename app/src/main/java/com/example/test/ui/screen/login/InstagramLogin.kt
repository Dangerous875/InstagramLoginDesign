package com.example.test.ui.screen.login

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.test.ui.components.IconClose
import com.example.test.ui.components.ImageInstagram
import com.example.test.ui.components.InputEmail
import com.example.test.ui.components.InputPassword

@Preview(
    name = "test",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 34,
    device = Devices.PIXEL_3A
)
@Composable
fun InstagramLogin() {
    LoginScreen()
}

@Composable
fun LoginScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .background(Color.White)
    ) {
        val actionBarTop = createGuidelineFromTop(0.02f)

        val idIconClose = createRef()
        val idImageInstagram = createRef()
        val idEmailUser = createRef()
        val idPasswordUser = createRef()
        val idForgotPassword = createRef()

        val activity = LocalContext.current as Activity

        var userEmail by rememberSaveable { mutableStateOf("") }
        var userPassword by rememberSaveable { mutableStateOf("") }

        IconClose(idIconClose, actionBarTop, activity)
        ImageInstagram(idImageInstagram, idIconClose)
        InputEmail(userEmail,idEmailUser, idImageInstagram) { userEmail = it }
        InputPassword(userPassword,idPasswordUser, idEmailUser) { userPassword = it }


    }
}





