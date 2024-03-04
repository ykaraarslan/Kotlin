package com.example.guessnumberapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultPage(result:Boolean) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        if (result){
            Text(text = "WON", fontSize = 24.sp, color = Color.Green)
            Image(painter = painterResource(id = R.drawable.image2), contentDescription = "")
        }else{
            Text(text = "LOSE", fontSize = 24.sp, color = Color.Red)
            Image(painter = painterResource(id = R.drawable.image3), contentDescription = "")
        }


    }
}