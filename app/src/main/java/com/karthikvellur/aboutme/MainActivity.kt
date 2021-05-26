package com.karthikvellur.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 'R' means resource which is a 'layout' and the name of the file is 'activity_main'
        // Hence R.layout.activity_main

        // Set the button onClick listener
        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it) // 'it' is the view on which it is being set. In this case it is the 'done' button
        }
    }

    /**
     * View is the view to which this function will be associated with
     * In this case it is the 'Done' button
     */
    private fun addNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nickNameTextView = findViewById<TextView>(R.id.nickname_text)

        nickNameTextView.text = editText.text
        editText.visibility = View.GONE // EditText will be hidden
        view.visibility = View.GONE // Button will be hidden
        nickNameTextView.visibility = View.VISIBLE

        // Hide the keyboard (After clicking on Done button)
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}