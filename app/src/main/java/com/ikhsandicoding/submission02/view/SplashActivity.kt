package com.ikhsandicoding.submission02.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ikhsandicoding.submission02.R


class SplashActivity : AppCompatActivity() {

    lateinit var topAnim: Animation
    lateinit var bottomAnim: Animation
    lateinit var image: ImageView
    lateinit var logo: TextView
    lateinit var slogan: TextView
    lateinit var progressBar: ProgressBar

    private val SPLASH_TIME_OUT: Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        //Hooks
        image = findViewById(R.id.imageView)
        logo = findViewById(R.id.textView)
        progressBar = findViewById(R.id.spin_kit)
        slogan = findViewById(R.id.textView2)
        //Set animation to elements
        image.animation = topAnim
        logo.animation = bottomAnim
        progressBar.animation = bottomAnim
        slogan.animation = bottomAnim

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}
