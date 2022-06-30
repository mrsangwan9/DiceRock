package com.example.dicerock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicerock.ui.theme.DiceRockTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRockTheme {
                DiceRocker()
            }
        }
    }

    @Composable
    fun DiceRocker() {
        DiceButtonAndImage(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )

    }

    @Composable
    fun DiceButtonAndImage(modifier: Modifier=Modifier) {
        var result by remember { mutableStateOf( 1) }


        val imageResource = when(result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        Column(modifier= modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            val image = painterResource(imageResource)
            Image(
                painter = image,
                contentDescription = "dice image"
            )

            Button(onClick = { result =(1..6).random() }) {

                Text(
                    text = stringResource(R.string.roll),
                    modifier = Modifier.padding(all = 10.dp),
                    fontSize = 20.sp
                )
            }

        }

    }
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        DiceRockTheme {
            DiceRocker()
        }
    }
}