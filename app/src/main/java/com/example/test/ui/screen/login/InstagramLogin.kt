package com.example.test.ui.screen.login

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.test.R
import com.example.test.ui.components.DividerLogin
import com.example.test.ui.components.IconClose
import com.example.test.ui.components.ImageInstagram
import com.example.test.ui.components.InputEmail
import com.example.test.ui.components.InputPassword
import com.example.test.ui.components.ShowForgotPassword

@Preview(
    name = "test",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 34,
    device = Devices.PIXEL_3A
)
@Composable
fun InstagramLogin() {
    val activity = LocalContext.current as Activity
    var userEmail by rememberSaveable { mutableStateOf("") }
    var userPassword by rememberSaveable { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .background(Color.White)
    ) {
        val actionBarTop = createGuidelineFromTop(0.02f)
        val (idIconClose, idImageInstagram, idEmailUser,
            idPasswordUser, idForgotPassword, idLineOR, idButtonLogin, idLoginFb ,idFooter) = createRefs()
        IconClose(idIconClose, actionBarTop, activity)
        ImageInstagram(idImageInstagram, idIconClose, idEmailUser)
        InputEmail(userEmail, idEmailUser, idImageInstagram) { userEmail = it }
        InputPassword(userPassword, idPasswordUser, idEmailUser) { userPassword = it }
        ShowForgotPassword(idForgotPassword, idPasswordUser)

        Button(modifier = Modifier
            .constrainAs(idButtonLogin) {
                top.linkTo(idForgotPassword.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(idLineOR.top)
            }
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
            onClick = { /*TODO*/ },
            colors = ButtonColors(
                containerColor = Color(0xFF47A6F1),
                contentColor = Color.White,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.White
            ), enabled = true
        ) {
            Text(text = "Log in")
        }


        DividerLogin(idLineOR, idButtonLogin)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .constrainAs(idLoginFb) {
                    top.linkTo(idLineOR.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(14.dp),
                painter = painterResource(id = R.drawable.iv_fb),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "Continue with Cristian Barzabal",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF152CB1)
            )


        }



    }
}










