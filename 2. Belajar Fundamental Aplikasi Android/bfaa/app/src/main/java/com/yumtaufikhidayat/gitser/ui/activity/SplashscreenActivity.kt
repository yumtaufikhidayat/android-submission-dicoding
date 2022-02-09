package com.yumtaufikhidayat.gitser.ui.activity

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.yumtaufikhidayat.gitser.databinding.ActivitySplashscreenBinding

class SplashscreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashscreenBinding
    private lateinit var handler: Handler
    private val delayMillis = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSplashscreen()
        setAppVersion()
    }

    private fun setSplashscreen() {

        handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, delayMillis)
    }

    private fun setAppVersion() {
        binding.apply {
            try {
                val pInfo: PackageInfo = packageManager.getPackageInfo(packageName, 0)
                val appVersion = pInfo.versionName
                tvAppVersion.text = appVersion
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
        }
    }
}