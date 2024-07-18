package com.example.test.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope
import com.example.test.R

@Composable
fun ConstraintLayoutScope.InputPassword(
    query: String,
    idPassword: ConstrainedLayoutReference,
    idEmailUser: ConstrainedLayoutReference,
    onChangePassword: (String) -> Unit
) {

    var visibility by rememberSaveable {
        mutableStateOf(false)
    }

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
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = { visibility = !visibility }) {
                if (!visibility) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_visibilityoff),
                        contentDescription = null
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_visibilityon),
                        contentDescription = null
                    )
                }
            }
        }, visualTransformation = if (visibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color(0xFF000000),
            focusedContainerColor = Color(0xFFFAFAFA),
            unfocusedContainerColor = Color(0xFFFAFAFA) ,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = Color.Black

        )
    )
}