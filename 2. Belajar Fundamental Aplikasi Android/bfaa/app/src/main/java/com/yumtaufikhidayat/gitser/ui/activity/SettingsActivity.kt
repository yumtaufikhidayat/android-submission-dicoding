package com.yumtaufikhidayat.gitser.ui.activity

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.yumtaufikhidayat.gitser.R
import com.yumtaufikhidayat.gitser.data.viewmodel.settings.SettingsViewModel
import com.yumtaufikhidayat.gitser.databinding.ActivitySettingsBinding
import com.yumtaufikhidayat.gitser.settings.SettingPreferences
import com.yumtaufikhidayat.gitser.utils.ViewModelFactory


class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionBar()
        initThemeMode()
    }

    private fun initActionBar() {
        supportActionBar?.apply {
            title = "Pengaturan"
            setDisplayHomeAsUpEnabled(true)
            elevation = 0F
        }
    }

    private fun initThemeMode() = with(binding) {
        val pref = SettingPreferences.getInstance(dataStore)
        val settingViewModel = ViewModelProvider(this@SettingsActivity, ViewModelFactory(pref))[SettingsViewModel::class.java]
        settingViewModel.getThemeSetting().observe(this@SettingsActivity) {
            if (it) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                swTheme.isChecked = true
                swTheme.setTextColor(ContextCompat.getColor(this@SettingsActivity, R.color.white))
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                swTheme.isChecked = false
            }
        }

        swTheme.setOnCheckedChangeListener { _: CompoundButton?, isChecked ->
            settingViewModel.saveThemeSetting(isChecked)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
    }
}