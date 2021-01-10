package io.realworld.anime_girls_change

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mp: MediaPlayer


    private val girlPhoto = listOf(
            R.drawable.girl,
        R.drawable.images1,
        R.drawable.images2,
        R.drawable.images3,
        R.drawable.images4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.images)

    private val girlSay = listOf(
            "yo", "baka", "hello", "I love u!", "why are u looking?", "goodbye!", "hentai!", "its me, baka")

    private val girlSound = listOf (
            R.raw.hey,
            R.raw.baka,
            R.raw.hmmph,
            R.raw.ilu,
            R.raw.muzukashii,
            R.raw.bye,
            R.raw.bakaringtone,
            R.raw.giggle,
            R.raw.dissapoint,
            R.raw.bududuubu,
                    R.raw.music,
                    R.raw.wow
            )
     var index = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var musicIndex = 0



        imageGirl.setOnClickListener {
            val mp = MediaPlayer.create(this, girlSound[musicIndex])
                if (musicIndex < girlSound.size) musicIndex ++
                else musicIndex = 0

            mp.start()
        }


        nextButton.setOnClickListener {
            Toast.makeText(this, "click nextButton, ${index}", Toast.LENGTH_SHORT).show()
            index =(index+1)% girlPhoto.size
            say.setText(girlSay[index])
            imageGirl.setImageResource(girlPhoto[index])
            playSound()
            }

        prevButton.setOnClickListener {
            Toast.makeText(this, "click prevButton, ${index}", Toast.LENGTH_SHORT).show()
            if (index!=0) {
                index = (index - 1) % girlPhoto.size
            }
            else index= girlPhoto.size - 1
            say.setText(girlSay[index])
            imageGirl.setImageResource(girlPhoto[index])
            playSound()
        }



}
    private fun playSound(){
        val mp = MediaPlayer.create(this, girlSound[index])
        mp.start()
    }
}