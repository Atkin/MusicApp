package com.example.musicapp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import com.example.musicapp.R


@Composable
fun homeScreen(navController: NavController) {
    val context = LocalContext.current
    Box(
        modifier = Modifier.clickable {
            Toast.makeText(context, "This is a test!", Toast.LENGTH_LONG).show()
        }
    ) {
        Column() {
            Row(
                Modifier
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                Button(
                    onClick = {
                        navController.navigate(Screens.ForestSounds.route)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.White),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = R.drawable.forest),
                            contentDescription = null,
                            modifier = Modifier.clip(CircleShape)
                        )
                        Text(
                            text = "Forest",
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            fontFamily = FontFamily.Cursive,
                        )
                    }
                }

                Button(
                    onClick = {
                        navController.navigate(Screens.SeaSounds.route)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.White),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = R.drawable.sea),
                            contentDescription = null,
                            modifier = Modifier.clip(CircleShape)
                        )
                        Text(
                            text = "Sea",
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            fontFamily = FontFamily.Cursive,
                        )
                    }
                }
            }
            Row(
                Modifier
                    .fillMaxHeight()
                    .weight(1f)

            ) {
                Button(
                    onClick = {
                        navController.navigate(Screens.WinterSounds.route)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.White),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = R.drawable.winter),
                            contentDescription = null,
                            modifier = Modifier.clip(CircleShape)
                        )
                        Text(
                            text = "Winter",
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            fontFamily = FontFamily.Cursive
                        )
                    }
                }

                Button(
                    onClick = {
                        navController.navigate(Screens.AudioRecorder.route)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.White),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = R.drawable.recorder),
                            contentDescription = null
                        )
                        Text(
                            text = "Audio Recorder",
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            fontFamily = FontFamily.Cursive,
                        )
                    }
                }
            }

            Row(
                Modifier
                    .fillMaxHeight()
                    .weight(1f)

            ) {
                Button(
                    onClick = {
                        navController.navigate(Screens.MediaPlayer.route)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.White),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = R.drawable.winter),
                            contentDescription = null,
                            modifier = Modifier.clip(CircleShape)
                        )
                        Text(
                            text = "Media Player",
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            fontFamily = FontFamily.Cursive
                        )
                    }
                }

                Button(
                    onClick = {
                        //Toast.makeText(context, "В разработке", Toast.LENGTH_LONG).show()
                        navController.navigate(Screens.TestScreen.route)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(Color.White),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = R.drawable.recorder),
                            contentDescription = null
                        )
                        Text(
                            text = "Empty",
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            fontFamily = FontFamily.Cursive,
                        )
                    }
                }
            }
        }
    }
}