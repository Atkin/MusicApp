package com.example.musicapp.screens

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.musicapp.R

@Composable
fun MediaPlayer() {
    val nowPlaying = "Now Playing"
    var songName = "Music"
    var startTime = "00.00"
    var songTime = "00.00"

    Column() {
        Row() {
            Text(text = nowPlaying)
            Text(text = songName)
        }

        Image(
            painter = painterResource(id = R.drawable.mp),
            contentDescription = "Image"
        )

        Row() {
            Text(text = startTime)
            Text(text = songTime)
        }

        Row() {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Default.Refresh
                    ,
                    contentDescription = "Refresh Button"
                )
            }
        }
    }
}