package com.example.activityresultapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityresultapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var observer: MyLifecycleObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observer = MyLifecycleObserver(this.activityResultRegistry, binding)
        lifecycle.addObserver(observer)

        binding.btnAdd.setOnClickListener {
            observer.selectImage()
        }

    }
}