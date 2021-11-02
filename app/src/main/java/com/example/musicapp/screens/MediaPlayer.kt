package com.example.musicapp.screens

import android.content.Context
import android.media.MediaPlayer
import android.os.Environment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.musicapp.R
import com.example.musicapp.data.Sounds

class MyMediaPlayer() {

    @Composable
    fun Play(context: Context, soundsList: List<Sounds>) {
//        var soundsList = mutableListOf(
//            Sounds("birds",
//                MediaPlayer.create(context, R.raw.birds),
//                false,
//                100.0.toString(),
//                Color.Green
//            ),
//            Sounds("water",
//                MediaPlayer.create(context, R.raw.ruchey),
//                false,
//                100.0.toString(),
//                Color.Blue
//            ),
//            Sounds("fire",
//                MediaPlayer.create(context, R.raw.fire),
//                false,
//                100.0.toString(),
//                Color.Red
//            ),
//            Sounds("night",
//                MediaPlayer.create(context, R.raw.night),
//                false,
//                100.0.toString(),
//                Color.DarkGray
//            )
//        )

        Column() {
            LazyColumn() {
                items(soundsList) { sound ->
                    //setSount(sound = sound)
                    ViewItem(sound = sound)
                }

            }
            Row() {


                Button(
                    onClick = {
                        for (sound in soundsList) {
                            if (sound != null) {
                                if (sound.isEnabled) {
                                    sound.sound!!.setVolume(
                                        getVolume(sound.soundValue.toDouble()),
                                        getVolume(sound.soundValue.toDouble())
                                    )
                                    //  sound.sound.prepare()
                                    sound.sound!!.start()
                                    sound.sound!!.isLooping = true
                                }
                            } else {
                                //need to update the list of Mediaplayers
                                //sound =
                            }
                        }
                    },
                    Modifier
                        .padding(4.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                ) {
                    Text(
                        text = "Start",
                        color = Color.White
                    )
                }

                Button(
                    onClick = {
                        for (sound in soundsList) {
                            //if (sound.sound.isPlaying) {
                            //    sound.sound.stop()
                            // }

                            if (sound.sound != null) {
                                sound.sound!!.stop()
                                sound.sound!!.release()
                                sound.sound = null
                            }
                        }
                    },
                    Modifier
                        .padding(4.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                ) {
                    Text(
                        text = "Stop",
                        color = Color.White
                    )
                }
            }

        }
    }

//    @Composable
//    fun setSount(sound: Sounds) {
//        sound.sound.setDataSource(
//            Environment.getExternalStorageDirectory().toString() + "/" +
//                    sound.soundTitle +
//                    ".mp3"
//        )
//    }

    fun getVolume(soundVolume: Double): Float {
        var MAX_VOLUME = 100.0
        return (1 - (Math.log(MAX_VOLUME - soundVolume) / Math.log(MAX_VOLUME))).toFloat()
    }

    @Composable
    fun ViewItem(
        sound: Sounds
    ) {
        var isEnabled = remember {
            mutableStateOf(false)
        }

        var volume = remember {
            mutableStateOf("100")
        }
        isEnabled.value = sound.isEnabled
        Card(
            shape = RoundedCornerShape(4.dp),
            backgroundColor = sound.backgroundColor,
        ) {
            Row {

                Checkbox(
                    checked = sound.isEnabled,
                    onCheckedChange = { isEndbledNew ->
                        sound.isEnabled = isEndbledNew
                        isEnabled.value = isEndbledNew
                    }
                )

                TextField(
                    value = volume.value,
                    onValueChange = { newVolume ->
                        if (!newVolume.isEmpty()) {
                            sound.soundValue = newVolume
                        }

                        volume.value = newVolume
                    },
                    label = {
                        Text(text = sound.soundTitle + " volume %")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    enabled = isEnabled.value
                )
            }
        }
    }
}

