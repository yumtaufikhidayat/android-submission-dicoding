package com.taufik.asean.ui.activity

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.taufik.asean.R
import com.taufik.asean.data.Country
import com.taufik.asean.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var country: Country

    companion object {
        const val EXTRA_DETAIL = "com.taufik.asean.ui.activity.EXTRA_DETAIL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setParcelable()

        setToolbar()

        setData()
    }

    private fun setParcelable() {
        country = intent.getParcelableExtra<Country>(EXTRA_DETAIL) as Country
    }

    private fun setToolbar() {
        supportActionBar?.apply {
            title = ""
            setDisplayHomeAsUpEnabled(true)
            elevation = 0F
        }
    }

    private fun setData() {
        binding.apply {
            Glide.with(this@DetailActivity)
                .load(country.countryFlag)
                .apply(RequestOptions()
                    .fitCenter()
                    .format(DecodeFormat.PREFER_ARGB_8888)
                    .override(Target.SIZE_ORIGINAL))
                .into(imgCountryFlag)

            tvCountryName.text = country.countryName
            tvCountryIntlName.apply {
                text = country.countryInternationalName
                setTypeface(null, Typeface.ITALIC)
            }
            tvCountryDesc.text = country.countryDescription
            tvCountryCapital.text = country.countryCapital
            tvCountryHeadGov.text = country.countryHeadGovernment
            tvCountryIndependenceDay.text = country.countryIndependenceDay
            tvCountryLanguage.text = country.countryLanguage
            tvCountryCurrency.text = country.countryCurrency
            tvCountryLandArea.text = country.countryLandArea
        }
    }

    private fun openInBrowser() {
        try {
            val link = "http://setnas-asean.id/profil-negara-anggota-asean"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(Intent.createChooser(intent, "Open with:"))
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "Silakan install browser terlebih dahulu",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.action_open_in_browser -> openInBrowser()
        }
        return super.onOptionsItemSelected(item)
    }
}