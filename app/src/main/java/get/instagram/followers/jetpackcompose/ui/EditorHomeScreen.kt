package get.instagram.followers.jetpackcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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
    var textOpacity by remember {
        mutableStateOf(1f)
    }
    var textsizeVisbility by remember {
        mutableStateOf(true)
    }
 var textOpacityVisbility by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .padding(16.dp)
        ) {

            Text(text = text, fontSize = textSize,
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
            Button(onClick = {
                textsizeVisbility = true
                textOpacityVisbility = false
            }) {
                Text(text = "size")
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


            Button(onClick = {
                textsizeVisbility = false
                textOpacityVisbility = true
            }) {
                Text(text = "Opacity")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}

