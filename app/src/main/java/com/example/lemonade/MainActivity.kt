package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {

             }
                }
            }
        }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonApp()
    }
}



@Composable
fun LemonApp() {

   var squeeze : Int by remember { mutableStateOf(0)}
    var currentStep: Int by remember { mutableStateOf(1) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {


        when (currentStep) {
            1 -> {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(painter = painterResource(id = R.drawable.lemon_tree),
                        contentDescription = stringResource(id = R.string.lemon_tree),
                        modifier = Modifier.clickable { currentStep = 2
                        squeeze = (2..4).random()})

                    Spacer(modifier = Modifier.padding(16.dp))

                    Text(
                        text = stringResource(id = R.string.tap),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
            }

            2 -> {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(painter = painterResource(id = R.drawable.lemon_squeeze),
                        contentDescription = stringResource(id = R.string.lemon),
                        modifier = Modifier.clickable { squeeze--
                        if(squeeze == 0) currentStep = 3})

                    Spacer(modifier = Modifier.padding(16.dp))

                    Text(
                        text = stringResource(id = R.string.keep_tapping),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )


                }
            }

            3 -> {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(painter = painterResource(id = R.drawable.lemon_drink),
                        contentDescription = stringResource(id = R.string.lemonade),
                        modifier = Modifier.clickable { currentStep = 4 })

                    Spacer(modifier = Modifier.padding(16.dp))

                    Text(
                        text = stringResource(id = R.string.drink),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }

            4 -> {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(painter = painterResource(id = R.drawable.lemon_restart),
                        contentDescription = stringResource(id = R.string.empty_glass),
                        modifier = Modifier.clickable { currentStep = 1 })

                    Spacer(modifier = Modifier.padding(16.dp))

                    Text(
                        text = stringResource(id = R.string.empty),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }

        }
    }
}