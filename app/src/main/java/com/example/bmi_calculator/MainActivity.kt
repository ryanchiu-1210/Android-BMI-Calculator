package com.example.bmi_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Label
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.util.VelocityTrackerAddPointsFix
import androidx.compose.ui.text.TextStyle
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
                var heightText by remember { mutableStateOf("") }
                var weightText by remember{ mutableStateOf("")}
                var output by remember { mutableStateOf("") }

                TextField(
                    value=heightText,
                    textStyle = TextStyle(fontSize = 20.sp),
                    onValueChange = {newHeight->heightText = newHeight},
                    placeholder = { Text("請輸入身高(cm)")},
                    modifier=Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                )
                TextField(
                    value = weightText,
                    textStyle = TextStyle(fontSize = 20.sp),
                    onValueChange = {newWeight->weightText=newWeight},
                    placeholder = {Text("請輸入體重(kg)")},
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                )
                Button(
                    onClick = {
                        var height :Int= heightText.toInt()/100
                        var weight : Int = weightText.toInt()

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                ){
                    Text("計算BMI")
                }
            }
    }
}

fun Calculator(height:Int,weight:Int): Int {
    return weight/(height*height)
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMI_CalculatorTheme {
        Greeting()
    }
}