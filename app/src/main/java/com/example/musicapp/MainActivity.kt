package com.example.musicapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import com.example.musicapp.ui.theme.MusicAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var filepath: Uri
    private lateinit var bitmap: Bitmap

    private lateinit var mr: MediaRecorder
    private var start: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.RECORD_AUDIO
            )
            != PackageManager.PERMISSION_GRANTED
        )
            ActivityCompat.requestPermissions(
                this, arrayOf(
                    android.Manifest.permission.RECORD_AUDIO,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ), 111
            )
        start = true

        setContent {
            MusicAppTheme {
                Navigation(this)
            }
        }
    }


    @SuppressLint("WrongConstant")
    @Composable
    fun AudioRecording() {
        val context = LocalContext.current
        var path: String = Environment.getExternalStorageDirectory().toString() + "/myrec.3gp"
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

        Column() {
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

            Image(
                painter = painterResource(id = R.drawable.forest),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        Toast.makeText(context, "This is a test!", Toast.LENGTH_LONG).show()
                    }
            )

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MusicAppTheme {
            //Greeting("Android")
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            start = true
    }

    @Composable
    fun ChooseFileTestScreen() {



        Column() {
            Row() {
                Button(
                    onClick = {
                        var i = Intent()
                        i.setType("image/*")
                        i.setAction(Intent.ACTION_GET_CONTENT)
                        startActivityForResult(Intent.createChooser(i, "Choose Picture"), 111)
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

                Button(
                    onClick = {
                        Toast.makeText(this@MainActivity, filepath.toString(), Toast.LENGTH_LONG).show()
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
        }
    }

    @Composable
    fun fileButton() {
        Button(
            onClick = {
                var i = Intent()
                i.setType("image/*")
                i.setAction(Intent.ACTION_GET_CONTENT)
                startActivityForResult(Intent.createChooser(i, "Choose Picture"), 111)
            },
            Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text(
                text = "Open",
                color = Color.White
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 111 && resultCode == Activity.RESULT_OK && data != null) {
            filepath = data.data!!
            bitmap = MediaStore.Images.Media.getBitmap(contentResolver,filepath)
        }
    }
}