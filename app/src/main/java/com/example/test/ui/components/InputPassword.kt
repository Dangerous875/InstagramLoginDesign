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
fun ConstraintLayoutScope.InputPassword(
    query : String,
    idPassword: ConstrainedLayoutReference,
    idEmailUser: ConstrainedLayoutReference,
    onChangePassword : (String) -> Unit
) {

    TextField(
        modifier = Modifier.Companion
            .constrainAs(idPassword) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(idEmailUser.bottom)
            }
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        value = query,
        onValueChange = { onChangePassword(it) },
        label = { Text(text = "Password", fontWeight = FontWeight.Light) },
        singleLine = true
    )
}