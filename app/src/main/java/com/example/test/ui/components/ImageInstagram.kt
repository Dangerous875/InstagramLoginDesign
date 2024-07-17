package com.example.test.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope
import com.example.test.R

@Composable
fun ConstraintLayoutScope.ImageInstagram(
    imageInstagram: ConstrainedLayoutReference,
    iconClose: ConstrainedLayoutReference
) {
    Image(
        modifier = Modifier.Companion
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
}