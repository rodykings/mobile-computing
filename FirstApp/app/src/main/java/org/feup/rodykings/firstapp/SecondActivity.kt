package org.feup.rodykings.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val message = TextView(this)
        message.textSize = 30.0F
        message.text = intent.getStringExtra(EXTRA_MESSAGE);
        setContentView(message)
    }
}