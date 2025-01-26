package com.jubayer_ahamad_tayef.gradient_button_practice_in_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jubayer_ahamad_tayef.gradient_button_practice_in_jetpack_compose.ui.theme.Color1
import com.jubayer_ahamad_tayef.gradient_button_practice_in_jetpack_compose.ui.theme.Color2
import com.jubayer_ahamad_tayef.gradient_button_practice_in_jetpack_compose.ui.theme.Gradient_Button_Practice_In_Jetpack_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Gradient_Button_Practice_In_Jetpack_ComposeTheme {
                MyGradientButton(onClick = {})
            }
        }
    }
}

@Composable
fun MyGradientButton(
    text: String = "Button",
    textColor: Color = Color.White,
    gradientColor: Brush = Brush.horizontalGradient(colors = listOf(Color1, Color2)),
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(),
            shape = RoundedCornerShape(10.dp),
            onClick = { onClick() }) {
            Box(
                modifier = Modifier
                    .background(gradientColor)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = text, color = textColor)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyGradientButtonPreview() {
    MyGradientButton(onClick = {})
}