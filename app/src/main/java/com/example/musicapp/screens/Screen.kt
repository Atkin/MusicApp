package com.example.musicapp.screens

sealed class Screens(val route: String) {
    object ChoiseMusicTheme: Screens("choise_music_theme")
    object ForestSounds: Screens("forest_sounds")
    object SeaSounds: Screens("sea_sounds")
    object WinterSounds: Screens("winter_sounds")
    object AudioRecorder: Screens("audio_recorder")
    object MediaPlayer: Screens("media_player")
    object TestScreen: Screens("testScreen")
}
