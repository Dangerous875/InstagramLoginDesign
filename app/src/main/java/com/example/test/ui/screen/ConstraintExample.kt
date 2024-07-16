package com.example.test.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun ConstraintExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxRed, boxBlue, boxYellow, boxMagenta , boxGrey) = createRefs()

        Box(    //BOX 1
            modifier = Modifier
                .size(125.dp)
                .background(color = Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Example")
        }

        Box(    //BOX 2
            modifier = Modifier
                .size(125.dp)
                .background(color = Color.Blue)
                .constrainAs(boxBlue) {
                    start.linkTo(boxMagenta.start)
                    top.linkTo(boxRed.bottom)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Example")
        }

        Box(    //BOX 3
            modifier = Modifier
                .size(125.dp)
                .background(color = Color.Yellow)
                .constrainAs(boxYellow) {
                    bottom.linkTo(boxRed.top)
                    end.linkTo(boxRed.start)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Example")
        }

        Box(    //BOX 4
            modifier = Modifier
                .size(125.dp)
                .background(color = Color.Magenta)
                .constrainAs(boxMagenta) {
                    start.linkTo(boxRed.end)
                    bottom.linkTo(boxRed.top)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Example")
        }

        Box(    //BOX 5
            modifier = Modifier
                .size(125.dp)
                .background(color = Color.Gray)
                .constrainAs(boxGrey) {
                    end.linkTo(boxRed.start)
                    top.linkTo(boxRed.bottom)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Example")
        }

    }
}

@Preview(
    name = "test",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 34,
    device = Devices.PIXEL_3A
)
@Composable
fun ConstraintLayoutGuide(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.1f)
        val boxRed = createRef()

        Box(
            modifier = Modifier
                .size(125.dp)
                .background(color = Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(topGuide)
                    start.linkTo(startGuide)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Example")
        }
    }
}