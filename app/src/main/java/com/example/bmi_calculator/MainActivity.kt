package com.example.bmi_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_calculator.ui.theme.BMI_CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMI_CalculatorTheme {
                Greeting()
                }
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("BMI計算器", fontSize = 30.sp)
                }
            )
        }
    ){innerPadding->
            Column(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
            ){
                /*TextField(modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
                    .
                ){

                }*/
            }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMI_CalculatorTheme {
        Greeting()
    }
}