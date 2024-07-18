package com.example.test.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope
import com.example.test.R

@Composable
fun ConstraintLayoutScope.LineOR(
    idLoginFb: ConstrainedLayoutReference,
    idLineOR: ConstrainedLayoutReference
) {
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