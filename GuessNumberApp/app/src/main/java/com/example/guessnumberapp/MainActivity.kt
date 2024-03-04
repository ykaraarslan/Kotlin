package com.example.guessnumberapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.guessnumberapp.ui.theme.GuessNumberAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessNumberAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PageTransition()
                }
            }
        }
    }
}
@Composable
fun PageTransition(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainpage"){
        composable("mainpage"){
            MainPage(navController = navController)}
        composable("guesspage"){
            GuessPage(navController = navController)
        }
        composable("resultpage/{result}", arguments = listOf(
            navArgument("result"){type= NavType.BoolType}
        )){
            val result = it.arguments?.getBoolean("result")!!
            ResultPage(result =result)
        }

    }

}


@Composable
fun MainPage(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "? Guess Number 0 to 100 ?", fontSize = 24.sp, color = Color.Blue)
        Image(painter = painterResource(id = R.drawable.image1), contentDescription = "")
        Button(onClick = { navController.navigate("guesspage") },modifier = Modifier.size(250.dp,50.dp)) {
            Text(text = "PLAY")
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GuessNumberAppTheme {

    }
}