package com.example.guessnumberapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuessPage(navController: NavController) {
    val tfGuess = remember { mutableStateOf("")}
    val randomNumber = remember { mutableStateOf(0)}
    val remainingLife = remember { mutableStateOf(7)}
    val help = remember { mutableStateOf("")}
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        LaunchedEffect(key1 = true){
            randomNumber.value = Random.nextInt(101)//0 to 100
        }
        Text(text = "Remaining Life : ${remainingLife.value}", fontSize = 24.sp, color = Color.Blue)
        Text(text = "Help : ${help.value}", fontSize = 24.sp, color = Color.Blue)
        TextField(
            value =tfGuess.value ,
            onValueChange = {tfGuess.value = it} ,
            label = { Text(text = "Guess")})
        Button(onClick = {
            remainingLife.value = remainingLife.value - 1
            val guess = tfGuess.value.toInt()
            if(guess== randomNumber.value){
                navController.navigate("resultpage/true"){
                    popUpTo("guesspage"){inclusive = true}
            }
                return@Button
            }
            if(guess > randomNumber.value){
                help.value = "Lower"
            }
            if(guess < randomNumber.value){
                help.value = "Upper"
            }
            if(remainingLife.value == 0){
                navController.navigate("resultpage/false"){
                    popUpTo("guesspage"){inclusive = true}
            }


            }
            tfGuess.value = "" },modifier = Modifier.size(250.dp,50.dp)) {

            Text(text = "GUESS")

        }
    }
}