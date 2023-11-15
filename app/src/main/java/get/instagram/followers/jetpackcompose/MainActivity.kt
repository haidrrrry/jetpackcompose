package get.instagram.followers.jetpackcompose

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import get.instagram.followers.jetpackcompose.ui.CustomText
import get.instagram.followers.jetpackcompose.ui.CustomTextSliderSection
import get.instagram.followers.jetpackcompose.ui.theme.JetpackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposeTheme {
              Column {
                  CustomTextSliderSection("yo nigga")

              }


            }
        }
    }
}

@Composable
fun imageRotationAndZoom(image: Int)
{
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1280f / 959f)
    ) {
        var scale by remember {
            mutableStateOf(1f)
        }

        var rotation by remember {
            mutableStateOf(1f)
        }
        var offset by remember {
            mutableStateOf(Offset.Zero)
        }
        val state= rememberTransformableState{zoomChange, panChange, rotationChange ->
            scale=(scale*zoomChange).coerceIn(1f,5f)
            rotation +=rotationChange
            val extraWidth=(scale-1)*constraints.maxWidth
            val extraHeight=(scale-1)*constraints.maxHeight
            val maxX=extraWidth/2
            val maxY=extraHeight/2
            offset=Offset(
                x=(offset.x +panChange.x).coerceIn(-maxX,maxX),
                y=(offset.y+panChange.y).coerceIn(-maxY,maxY),
            )
            // offset +=panChange
        }
        Image(painter = painterResource(id = image),
            contentDescription =null,
            modifier = Modifier.align(Alignment.BottomCenter)
//                .fillMaxWidth().pointerInput(Unit) {
//                    detectTransformGestures { _, _, zoom, _ ->
//                        scale = when {
//                            scale < 0.5f -> 0.5f
//                            scale > 3f -> 3f
//                            else -> scale * zoom
//                        }
//                    }
//
//                }


                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    rotationZ = rotation
                    translationX = offset.x
                    translationY = offset.y
                }
                .transformable(state)

        )
    }
}



