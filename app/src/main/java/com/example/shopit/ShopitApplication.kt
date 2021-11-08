package com.example.shopit


import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class ShopItApplication : Application() {
    companion object {
        lateinit var instance: ShopItApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

}