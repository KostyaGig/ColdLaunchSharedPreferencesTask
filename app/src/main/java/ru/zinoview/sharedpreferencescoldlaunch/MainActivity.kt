package ru.zinoview.sharedpreferencescoldlaunch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferencesCountLaunch = SharedPreferencesCountLaunch.Base(applicationContext)

        if (sharedPreferencesCountLaunch.isShow()) {
            Toast.makeText(applicationContext, "The third launch was made", Toast.LENGTH_SHORT).show()
        } else {
            sharedPreferencesCountLaunch.launched()
        }

    }
}