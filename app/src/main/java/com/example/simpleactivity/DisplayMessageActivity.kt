package com.example.simpleactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.simpleactivity.R.layout

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_display_message)

        val message: String = intent.getStringExtra(EXTRA_MESSAGE)

        val textView: TextView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }
    }

    /**
     * トップページをレンダリングする
     * @param view
     */
    fun renderMain(view: View) {

        val intent: Intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
    }
}
