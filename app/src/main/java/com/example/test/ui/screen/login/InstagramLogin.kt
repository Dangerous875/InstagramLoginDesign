package com.example.test.ui.screen.login

import android.app.Activity
import android.util.Patterns
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
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.test.ui.components.ButtonLogin
import com.example.test.ui.components.DividerLogin
import com.example.test.ui.components.IconClose
import com.example.test.ui.components.ImageInstagram
import com.example.test.ui.components.InputEmail
import com.example.test.ui.components.InputPassword
import com.example.test.ui.components.LineOR
import com.example.test.ui.components.ShowForgotPassword


@Composable
fun InstagramLogin() {
    val activity = LocalContext.current as Activity
    var userEmail by rememberSaveable { mutableStateOf("") }
    var userPassword by rememberSaveable { mutableStateOf("") }
    var enableButtonLogin by rememberSaveable {
        mutableStateOf(false)
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .background(Color.White)
    ) {
        val actionBarTop = createGuidelineFromTop(0.02f)
        val (idIconClose, idImageInstagram, idEmailUser,
            idPasswordUser, idForgotPassword, idLineOR, idButtonLogin, idLoginFb) = createRefs()
        IconClose(idIconClose, actionBarTop, activity)
        ImageInstagram(idImageInstagram, idIconClose, idEmailUser)
        InputEmail(userEmail, idEmailUser, idImageInstagram) {
            userEmail = it
            enableButtonLogin = enableLogin(userEmail, userPassword)
        }
        InputPassword(userPassword, idPasswordUser, idEmailUser) {
            userPassword = it
            enableButtonLogin = enableLogin(userEmail, userPassword)
        }
        ShowForgotPassword(idForgotPassword, idPasswordUser)
        ButtonLogin(enableButtonLogin, idButtonLogin, idForgotPassword, idLineOR)
        DividerLogin(idLineOR, idButtonLogin)
        LineOR(idLoginFb, idLineOR)
    }
}

fun enableLogin(userEmail: String, userPassword: String): Boolean =
    (Patterns.EMAIL_ADDRESS.matcher(userEmail).matches() && (userPassword.length >= 6))















