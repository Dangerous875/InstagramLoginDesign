package com.example.test.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope

@Composable
fun ConstraintLayoutScope.InputEmail(
    query : String,
    emailUser: ConstrainedLayoutReference,
    imageInstagram: ConstrainedLayoutReference,
    onChangeEmail : (String) -> Unit
) {

    TextField(
        modifier = Modifier.Companion
            .constrainAs(emailUser) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(imageInstagram.bottom)
            }
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        value = query,
        onValueChange = { onChangeEmail(it) },
        label = { Text(text = "Email", fontWeight = FontWeight.Light) },
        singleLine = true
    )
}