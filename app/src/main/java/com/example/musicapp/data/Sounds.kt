package com.example.musicapp.data

import androidx.compose.ui.graphics.Color
import android.media.MediaPlayer

data class Sounds(
    var soundTitle: String,
    var sound: MediaPlayer,
    var isEnabled: Boolean,
    var soundValue:String,
    var backgroundColor: Color
)
