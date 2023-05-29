package com.example.galeriadearte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.galeriadearte.ui.theme.GaleriaDeArteTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GaleriaDeArteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GaleriaDeArte()

                }
            }
        }
    }
}
@Composable
fun GaleriaDeArte(){
    var indexDeObros by remember { mutableStateOf(0) }
    val galeriaDeObras = listOf(
        R.drawable.obra1,
        R.drawable.obra2,
        R.drawable.androidparty,
        R.drawable.bi,
        R.drawable.png_transparent_ironhide_youtube_transformers_film_autobot_transformer_metal_transformers_prime_transformers_age_of_extinction
    )
    ImageWithTexts(
        obra = painterResource(id = galeriaDeObras[indexDeObros]),
        preview = { indexDeObros = (indexDeObros - 1).coerceAtLeast(0) },
        next = { indexDeObros = (indexDeObros + 1).coerceAtMost(galeriaDeObras.lastIndex) }) {

    }

}

@Composable
fun ImageWithTexts(
    obra: Painter,
    preview: ()-> Unit,
    next: () -> Unit,
    function: () -> Unit,
){
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            modifier = Modifier.size(300.dp),
            painter = obra,
            contentDescription = "",
        )
        Text(
            text = "Artista Desconhecido",
            fontSize = 25.sp,
            fontFamily = FontFamily.SansSerif,
        )
        Text(
            text = "atwork artis (year",
            fontSize = 25.sp,
            fontFamily = FontFamily.SansSerif,
        )
        ButtonOfRow(onPreviewbutton = preview, onNextButton = next) {
            
        }
    }
}

@Composable
fun ButtonOfRow(
    onPreviewbutton: () -> Unit,
    onNextButton: () -> Unit,
    function: () -> Unit,
){
    Row(
        horizontalArrangement = Arrangement.Center,

        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Button(onClick = onPreviewbutton) {
            Text(text = "Preview")
        }
        Button(onClick = onNextButton) {
            Text(text = "Preview")
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GaleriaDeArtePreview() {
    ImageWithTexts(obra = painterResource(id = R.drawable.androidparty), preview = { /*TODO*/ }, next = { /*TODO*/ }) {
        
    }
}
