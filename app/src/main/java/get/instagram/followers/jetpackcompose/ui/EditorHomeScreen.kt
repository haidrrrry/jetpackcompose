package get.instagram.followers.jetpackcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt


@Composable
fun EditorHomeScreen() {
}


@Composable
fun CustomText()
{
var fontSize by remember {
    mutableStateOf(20.sp)
}
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text(text = "Hello World!",
            fontSize = fontSize,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp))

        Slider(value = fontSize.value,
            onValueChange ={
                fontSize=it.sp
                           },
            valueRange = 1f..500f,
            steps = 40,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
            )
    }
}


@Composable
fun CustomTextSliderSection(text:String)
{
    var textSize by remember {
        mutableStateOf(10.sp)
    }
    var offset by remember { mutableStateOf(Offset(0f, 0f)) }

    var textOpacity by remember {
        mutableStateOf(1f)
    }
    var textsizeVisbility by remember {
        mutableStateOf(true)
    }
    var FontVisbility by remember {
        mutableStateOf(false)
    }
 var textOpacityVisbility by remember {
        mutableStateOf(false)
    }

    var fontFamily by remember { mutableStateOf(FontFamily.Default) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .offset {
                IntOffset(offset.x.roundToInt(), offset.y.roundToInt())
            }
                .align(Alignment.BottomCenter)
            .padding(16.dp)
        ) {

            Text(text = text, fontSize = textSize,fontFamily=fontFamily,
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(textOpacity)
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (textsizeVisbility) {
                Slider(value = textSize.value, onValueChange = {
                    textSize=it.sp
                },
                    valueRange = 10f..50f,
                    steps = 40,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            if (textOpacityVisbility) {
                Slider(value = textOpacity, onValueChange ={
                    textOpacity=it
                }, valueRange = 0f..1f,
                    steps = 100,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp))
            }

            if (FontVisbility)
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.Bottom

                ) {
                    Button(
                        onClick = { fontFamily = FontFamily.Cursive },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text("Cursive")
                    }

                    Button(
                        onClick = { fontFamily = FontFamily.SansSerif },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text("Sans Serif")
                    }

                    Button(
                        onClick = { fontFamily = FontFamily.Monospace },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text("Monospace")
                    }

                    Text(
                        text = text,
                        fontFamily = fontFamily,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }


            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {

                Button(onClick = {
                    textsizeVisbility = false
                    textOpacityVisbility = true
                    FontVisbility = false
                }) {
                    Text(text = "Opacity")
                }

                Button(onClick = {
                    textsizeVisbility = true
                    textOpacityVisbility = false
                    FontVisbility = false
                }) {
                    Text(text = "size")
                }
                Button(onClick = {  textsizeVisbility = false
                    textOpacityVisbility = false
                    FontVisbility = true}) {
                     Text(text = "FontFamily")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}

@Composable
fun DynamicText(text: String, isSelected: Boolean, onTextClick: () -> Unit) {
    Text(
        text = text,
        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
        color = if (isSelected) Color.Red else Color.Black,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onTextClick() }
    )
}

