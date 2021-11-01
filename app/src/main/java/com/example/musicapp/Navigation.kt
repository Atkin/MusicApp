package com.example.musicapp

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.data.getSoundsList
import com.example.musicapp.screens.*

@Composable
fun Navigation(context: Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.ChoiseMusicTheme.route) {
        composable(route = Screens.ChoiseMusicTheme.route) {
            homeScreen(navController = navController)
        }
        composable(route = Screens.ForestSounds.route) {
            MyMediaPlayer().Play(context, getSoundsList().getForestSounds(context))
        }
        composable(route = Screens.SeaSounds.route) {
            MyMediaPlayer().Play(context, getSoundsList().getSeaSounds(context))
        }
        composable(route = Screens.WinterSounds.route) {
            MyMediaPlayer().Play(context, getSoundsList().getWinterSounds(context))
        }
        composable(route = Screens.AudioRecorder.route) {
           MainActivity().AudioRecording()
        }
        composable(route = Screens.MediaPlayer.route) {
            MediaPlayerScreen()
        }
        composable(route = Screens.TestScreen.route) {
            ChooseFileTestScreen()
        }
    }
}
