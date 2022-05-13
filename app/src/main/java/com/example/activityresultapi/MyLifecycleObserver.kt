package com.example.activityresultapi

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.activityresultapi.databinding.ActivityMainBinding

class MyLifecycleObserver(private val registry : ActivityResultRegistry, val binding: ActivityMainBinding) : DefaultLifecycleObserver{
    lateinit var getContent : ActivityResultLauncher<String>

    override fun onCreate(owner: LifecycleOwner) {
        getContent = registry.register("key", owner, ActivityResultContracts.GetContent()){ uri ->
            binding.ivImage.setImageURI(uri)
        }
    }

    fun selectImage() {
        getContent.launch("image/*")
    }
}