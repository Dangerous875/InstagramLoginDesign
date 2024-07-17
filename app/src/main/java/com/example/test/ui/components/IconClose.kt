package com.example.test.ui.components

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope
import androidx.constraintlayout.compose.ConstraintLayoutScope
import com.example.test.R

@Composable
fun ConstraintLayoutScope.IconClose(
    iconClose: ConstrainedLayoutReference,
    actionBarTop: ConstraintLayoutBaseScope.HorizontalAnchor,
    activity: Activity
) {
    Icon(
        modifier = Modifier
            .constrainAs(iconClose) {
                top.linkTo(actionBarTop)
                end.linkTo(parent.end)
            }
            .clickable { activity.finish() },
        painter = painterResource(id = R.drawable.ic_close),
        contentDescription = null
    )
}