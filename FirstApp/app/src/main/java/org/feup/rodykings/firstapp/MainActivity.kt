package org.feup.rodykings.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

const val EXTRA_MESSAGE = "org.feup.rodykings.firstapp.EXTRA_MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //find the button by resources id
        findViewById<Button>(R.id.button).setOnClickListener { _ -> onButtonClick()};
        }

    private fun onButtonClick() {
        val secondIntent = Intent(this, SecondActivity::class.java)
        secondIntent.putExtra(EXTRA_MESSAGE, findViewById<EditText>(R.id.edit_text).text.toString())
        startActivity(secondIntent)
    }
}
