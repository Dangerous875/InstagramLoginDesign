package com.example.test.ui.screen.login

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.test.R
import com.example.test.ui.components.IconClose

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
        val iconClose = createRef()
        val imageInstagram = createRef()
        val emailUser = createRef()
        val activity = LocalContext.current as Activity
        var user by rememberSaveable {
            mutableStateOf("")
        }

        IconClose(iconClose, actionBarTop, activity)

        Image(
            modifier = Modifier
                .constrainAs(imageInstagram) {
                    top.linkTo(iconClose.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .size(250.dp),
            painter = painterResource(id = R.drawable.iv_insta),
            contentDescription = null
        )

        TextField(
            modifier = Modifier
                .constrainAs(emailUser) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(imageInstagram.bottom)
                }
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            value = user,
            onValueChange = { user = it },
            label = { Text(text = "Email", fontWeight = FontWeight.Light) },
            singleLine = true
        )


    }
}



