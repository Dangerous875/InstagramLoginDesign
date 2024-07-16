package com.example.test.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.test.R

@Preview(
    name = "test",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 34,
    device = Devices.PIXEL_3A
)
@Composable
fun ComponentsCompose() {
    ShowPreview()
}

@Composable
fun ShowPreview() {
    MyTextField()
}

@Composable
fun MyText() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is a example 1 ", fontSize = 16.sp)
        Text(text = "This is a example 2 ", fontSize = 16.sp, color = Color.Blue)
        Text(text = "This is a example 3 ", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
        Text(text = "This is a example 4 ", fontSize = 16.sp, fontWeight = FontWeight.Light)
        Text(
            text = "This is a example 5 ",
            fontSize = 16.sp,
            style = TextStyle(fontFamily = FontFamily.Cursive)
        )
        Text(text = "This is a example 6 ", fontSize = 16.sp, fontStyle = FontStyle.Italic)
        Text(text = "This is a example 7 ", fontSize = 16.sp, fontStyle = FontStyle.Normal)
        Text(text = "This is a example 8 ", fontFamily = FontFamily(Font(R.font.font_blazed)))
        Text(
            text = "This is an example 9 ", fontSize = 16.sp, fontStyle = FontStyle.Normal,
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = "This is an example 10 ", fontSize = 16.sp, fontStyle = FontStyle.Normal,
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = "This is an example 11 ", fontSize = 16.sp, fontStyle = FontStyle.Normal,
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline,
                    TextDecoration.LineThrough
                )
            )
        )

    }
}

@Composable
fun MyTextField() {
    var myText by rememberSaveable { mutableStateOf("") }

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (textF1, textF2, outF3) = createRefs()

        TextField(modifier = Modifier.constrainAs(textF1) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(textF2.top)
        }, value = myText,
            onValueChange = { myText = it },
            placeholder = { Text(text = "Introduce tu nombre : ") }
        )

        OutlinedTextField(modifier = Modifier.constrainAs(outF3) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            top.linkTo(textF2.bottom)
        },
            value = myText,
            onValueChange = { myText = it },
            label = { Text(text = "Introduce tu nombre2 : ") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Green,
                unfocusedBorderColor = Color.Red
            )
        )

        TextField(modifier = Modifier.constrainAs(textF2) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            top.linkTo(textF1.bottom)
        }, value = myText,
            onValueChange = { myText = it },
            label = { Text(text = "Introduce tu nombre2 : ") }
        )
    }

}















