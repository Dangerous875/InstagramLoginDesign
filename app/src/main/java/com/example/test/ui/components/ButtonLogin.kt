package com.example.test.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope

@Composable
fun ConstraintLayoutScope.ButtonLogin(
    enableButtonLogin: Boolean,
    idButtonLogin: ConstrainedLayoutReference,
    idForgotPassword: ConstrainedLayoutReference,
    idLineOR: ConstrainedLayoutReference
) {

    val context = LocalContext.current
    Button(modifier = Modifier.Companion
        .constrainAs(idButtonLogin) {
            top.linkTo(idForgotPassword.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(idLineOR.top)
        }
        .fillMaxWidth()
        .padding(horizontal = 16.dp),
        onClick = {
            if (enableButtonLogin) {
                Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Field not available", Toast.LENGTH_SHORT).show()
            }
        },
        enabled = enableButtonLogin,
        colors = ButtonColors(
            containerColor = Color(0xFF1393F5),
            disabledContainerColor = Color(0xFF47A6F1),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = "Log in")
    }
}