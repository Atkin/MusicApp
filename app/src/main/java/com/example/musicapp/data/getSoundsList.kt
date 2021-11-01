package com.example.musicapp.data

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.ui.graphics.Color
import com.example.musicapp.R

class getSoundsList {
    fun getForestSounds(context: Context): List<Sounds> {
        return mutableListOf(
            Sounds("birds",
                MediaPlayer.create(context, R.raw.birds),
                false,
                100.0.toString(),
                Color.Green
            ),
            Sounds("water",
                MediaPlayer.create(context, R.raw.ruchey),
                false,
                100.0.toString(),
                Color.Blue
            ),
            Sounds("fire",
                MediaPlayer.create(context, R.raw.fire),
                false,
                100.0.toString(),
                Color.Red
            ),
            Sounds("night",
                MediaPlayer.create(context, R.raw.night),
                false,
                100.0.toString(),
                Color.DarkGray
            )
        )
    }

    fun getSeaSounds(context: Context): List<Sounds> {
        return mutableListOf(
            Sounds("sea",
                MediaPlayer.create(context, R.raw.sea),
                false,
                100.0.toString(),
                Color.Blue
            ),
            Sounds("chaiki",
                MediaPlayer.create(context, R.raw.chaiki),
                false,
                100.0.toString(),
                Color.Gray
            )
        )
    }

    fun getWinterSounds(context: Context): List<Sounds> {
        return mutableListOf(
            Sounds("fire",
                MediaPlayer.create(context, R.raw.fire),
                false,
                100.0.toString(),
                Color.Red
            ),
            Sounds("wind",
                MediaPlayer.create(context, R.raw.wind),
                false,
                100.0.toString(),
                Color.Gray
            ),
            Sounds("rain",
                MediaPlayer.create(context, R.raw.rain),
                false,
                100.0.toString(),
                Color.Blue
            ),
            Sounds("lighting",
                MediaPlayer.create(context, R.raw.lightting),
                false,
                100.0.toString(),
                Color.Yellow
            )
        )
    }

}