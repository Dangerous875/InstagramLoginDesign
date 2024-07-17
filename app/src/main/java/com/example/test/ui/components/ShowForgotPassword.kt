package com.example.test.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope

@Composable
fun ConstraintLayoutScope.ShowForgotPassword(
    idForgotPassword: ConstrainedLayoutReference,
    idPasswordUser: ConstrainedLayoutReference
) {
    Text(modifier = Modifier.Companion
        .constrainAs(idForgotPassword) {
            end.linkTo(parent.end)
            top.linkTo(idPasswordUser.bottom)
        }
        .padding(end = 16.dp),
        text = "Forgot password?",
        fontWeight = FontWeight.ExtraBold,
        fontSize = 12.sp,
        color = Color(0XFF4EA8E9))
}