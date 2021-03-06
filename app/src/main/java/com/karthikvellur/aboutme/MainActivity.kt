package com.karthikvellur.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.karthikvellur.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Binding Object
    private lateinit var binding: ActivityMainBinding

    // Instance of data class
    private val myNameObj: MyName = MyName("Karthik Vellur")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 'R' means resource which is a 'layout' and the name of the file is 'activity_main'. Hence R.layout.activity_main
//        setContentView(R.layout.activity_main)
        // Replacement of setContentView via Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.activityXMLDataVal = myNameObj

        // Set the button onClick listener
//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it) // 'it' is the view on which it is being set. In this case it is the 'done' button
//        }

        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
    }

    /**
     * View is the view to which this function will be associated with
     * In this case it is the 'Done' button
     */
    private fun addNickname(view: View){
        // binding.apply is used to group the statements, instead of writing binding for every statement
        binding.apply {
//            nicknameText.text = binding.nicknameEdit.text
            activityXMLDataVal?.nickname = nicknameEdit.text.toString()
            invalidateAll() // Refreshes the UI with new data
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard (After clicking on Done button)
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}