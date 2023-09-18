package br.com.fiap.healthtech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healthtech.screens.CadastroScreen
import br.com.fiap.healthtech.screens.LoginScreen
import br.com.fiap.healthtech.ui.theme.HealthTechTheme
import br.com.fiap.healthtech.screens.ListHospitalsScreen

//import com.google.accompanist.navigation.animation.AnimatedNavHost
//import com.google.accompanist.navigation.animation.rememberAnimatedNavController
//import com.google.accompanist.navigation.animation.composable

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthTechTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController,
                        startDestination = "login",
//                        exitTransition = {
//                            slideOutOfContainer(
//                                AnimatedContentScope.SlideDirection.Left,
//                                animationSpec = tween(700)
//                            )
//                        }
                    ){
                        composable(route = "login"){
                            LoginScreen(navController)
                        }
                        composable(route = "cadastro"){
                            CadastroScreen(navController)
                        }
                        composable(route = "hospitals"){
                            ListHospitalsScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
