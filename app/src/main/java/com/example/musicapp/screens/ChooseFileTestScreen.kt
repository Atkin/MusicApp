package com.example.musicapp.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicapp.R

@Composable
fun ChooseFileTestScreen() {
    var i = Intent()
    i.setType("image/*")
    i.setAction(Intent.ACTION_GET_CONTENT)


    Column() {
        Row() {
            Button(
                onClick = {

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
        }

        Image(
            painter = painterResource(id = R.drawable.forest),
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    //Toast.makeText(context, "This is a test!", Toast.LENGTH_LONG).show()
                }
        )
    }
}