package com.alfayedoficial.kotlinutilsV2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alfayedoficial.kotlinutils.kuRunDelayed

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kuRunDelayed(500){

        }
    }
}