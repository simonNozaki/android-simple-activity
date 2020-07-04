package com.example.simpleactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.example.simpleactivity.R.layout
import com.example.simpleactivity.fragment.PageBottomFragment
import com.example.simpleactivity.util.app
import com.example.simpleactivity.util.printStack

const val EXTRA_MESSAGE: String = "com.example.simpleactivity.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        val textView: TextView = findViewById(R.id.mainText)
        textView.text = "development"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val pageBottomFragment: PageBottomFragment =
            PageBottomFragment()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.fragment, pageBottomFragment)

        fragmentTransaction.commit()
    }

    /**
     * メッセージを生成し、ページをレンダリングする
     * @param view
     */
    fun sendMessage(view: View) {

        println(app.printStack("メッセージの処理を開始します。"))

        val editText: EditText = findViewById(R.id.editText)
        val message: String = editText.text.toString()

        val intent: Intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }

        startActivity(intent)

        println(app.printStack("メッセージの処理を終了します。"))
    }
}
