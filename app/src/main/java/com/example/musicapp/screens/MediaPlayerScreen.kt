package com.example.musicapp.screens

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.musicapp.R

    @Composable
    fun MediaPlayerScreen() {
        val options: Bundle? = null
        val context = LocalContext.current
        var mp = MediaPlayer.create(context, R.raw.music)
        Column() {
            Row {
                Button(
                    onClick = {
                        if (mp == null) {
                            mp = MediaPlayer.create(context, R.raw.music)
                            mp.start()
                        } else {
                            mp.start()
                        }
                    },
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .weight(1F),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {
                    Text(
                        text = "Start",
                        color = Color.White
                    )
                }

                Button(
                    onClick = {
                        if (mp != null && mp.isPlaying) {
                            mp.pause()
                        } else {
                            Toast.makeText(context, "Запустите трек!", Toast.LENGTH_SHORT).show()
                        }
                    },
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .weight(1F),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {
                    Text(
                        text = "Pause",
                        color = Color.White
                    )
                }

                Button(
                    onClick = {
                        if (mp != null) {
                            mp.stop()
                            mp.release()
                            mp = null
                        }
                    },
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .weight(1F),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {
                    Text(
                        text = "Stop",
                        color = Color.White
                    )
                }

                Button(
                    onClick = {
                        var i = Intent()
                        i.setType("image/*")
                        i.setAction(Intent.ACTION_GET_CONTENT)
                        startActivity(context, Intent.createChooser(i, "Choose Picture"), options)
                    },
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .weight(1F),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {
                    Text(
                        text = "Open",
                        color = Color.White
                    )
                }

            }
        }
    }
