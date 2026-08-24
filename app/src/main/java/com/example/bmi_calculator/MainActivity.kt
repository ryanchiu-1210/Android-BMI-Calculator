package com.example.bmi_calculator

import android.content.Context
import android.net.wifi.WifiEnterpriseConfig
import android.os.Bundle
import android.renderscript.Sampler.Value
import android.widget.Toast
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_calculator.ui.theme.BMI_CalculatorTheme
import kotlin.math.roundToInt

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
    var context = LocalContext.current
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
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
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
                        try{
                            var height :Float= heightText.toInt()/100f
                            var weight : Float= weightText.toFloat()
                            output = Calculator(height,weight)
                        }
                        catch(e:Exception){
                            Toast.makeText(context, "Format Error", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                ){
                    Text("計算BMI", fontSize = 20.sp)
                }
                Text(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                    text = "BMI值為:${output}", fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                )
            }
    }
}



fun Calculator(height:Float,weight:Float): String {
    var bmi :Float= (weight/(height*height))
    var formatted = "%.1f".format(bmi)
    return formatted
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMI_CalculatorTheme {
        Greeting()
    }
}