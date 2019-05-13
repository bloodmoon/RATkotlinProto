package com.example.ratkotlinproto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.Random

class SecondActivity : AppCompatActivity() {

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showRandomNumber()
    }

    fun showRandomNumber(){

        //Get the count from extras
        val count = intent.getIntExtra(TOTAL_COUNT, 0)

        //Generate Random number
        var random = Random()
        var randomInt = 0

        //Add on b/c bounds are exclusive
        if(count>0){
            randomInt = random.nextInt(count+1)
        }

        //Display the random number
        findViewById<TextView>(R.id.textView_random).text = Integer.toString(randomInt)

        //Make string resource dynamic to update with current max number
        findViewById<TextView>(R.id.textview_label).text = getString(R.string.random_heading, count)
    }
}
