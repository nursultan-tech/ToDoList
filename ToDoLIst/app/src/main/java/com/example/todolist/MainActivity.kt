package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.MainActivity

class MainActivity : AppCompatActivity() {
    var topAnim: Animation? = null
    var bottomAnim: Animation? = null
    var imageView: ImageView? = null
    var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
//        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
//        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
//        imageView = findViewById(R.id.imageView)
//        textView = findViewById(R.id.text)

        AnimationUtils.loadAnimation(this, R.anim.top_animation).also { topAnim ->
            findViewById<ImageView>(R.id.imageView).startAnimation(topAnim)
        }


        AnimationUtils.loadAnimation(this, R.anim.bottom_animation).also { bottomAnim ->
            findViewById<TextView>(R.id.text).startAnimation(bottomAnim)
        }
//        imageView.setAnimation(topAnim)
//        textView.setAnimation(bottomAnim)
        Handler().postDelayed({
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH.toLong())
    }

    companion object {
        private const val SPLASH = 3300
    }
}