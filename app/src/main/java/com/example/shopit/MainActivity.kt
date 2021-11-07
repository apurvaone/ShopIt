package com.example.shopit

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {


//            val decorView: View = window.decorView
//            val uiOptions: Int = View.SYSTEM_UI_FLAG_FULLSCREEN
//            decorView.setSystemUiVisibility(uiOptions)
//            val actionBar: ActionBar? = actionBar
//            actionBar!!.hide()


            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, LoginFragment())
                .commit()
//
            if (supportActionBar!=null) {
                supportActionBar!!.hide()
            }

            }
        }

    }
