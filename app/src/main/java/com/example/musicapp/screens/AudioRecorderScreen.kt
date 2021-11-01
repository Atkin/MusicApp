package com.example.musicapp.screens

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Environment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class Record() {
    private lateinit var mr: MediaRecorder

    @SuppressLint("WrongConstant")
    @Composable
    fun AudioRecording() {
        val path = Environment.getExternalStorageDirectory().toString() + "/myrecord.3gp"
        mr = MediaRecorder()

        var start = remember {
            mutableStateOf(true)
        }

        var stop = remember {
            mutableStateOf(false)
        }

        var play = remember {
            mutableStateOf(false)
        }

        Row() {
            Button(
                onClick = {
                    mr.setAudioSource(MediaRecorder.AudioSource.MIC)
                    mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                    mr.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB)
                    mr.setOutputFile(path)
                    mr.prepare()
                    mr.start()
                    start.value = false
                    stop.value = true
                },
                Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                enabled = start.value
            ) {
                Text(
                    text = "Start",
                    color = Color.White
                )
            }

            Button(
                onClick = {
                    mr.stop()
                    stop.value = false
                    start.value = true
                    play.value = true
                },
                Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                enabled = stop.value
            ) {
                Text(
                    text = "Stop",
                    color = Color.White
                )
            }

            Button(
                onClick = {
                    var mp = MediaPlayer()
                    mp.setDataSource(path)
                    mp.prepare()
                    mp.start()
                },
                Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                enabled = play.value
            ) {
                Text(
                    text = "Play",
                    color = Color.White
                )
            }
        }
    }
}