package com.taufik.asean.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.taufik.asean.R
import com.taufik.asean.databinding.ActivityProfileBinding
import com.taufik.asean.utils.Utils.githubUrl
import com.taufik.asean.utils.Utils.makeLinks


class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()

        setProfileData()

        setInitOnClick()
    }

    private fun setToolbar() {
        supportActionBar?.apply {
            title = ""
            setDisplayHomeAsUpEnabled(true)
            elevation = 0F
        }
    }

    @SuppressLint("CheckResult")
    private fun setProfileData() {
        binding.apply {
            Glide.with(this@ProfileActivity)
                .load(R.drawable.pp_taufik)
                .apply(RequestOptions()
                        .fitCenter()
                        .format(DecodeFormat.PREFER_ARGB_8888)
                        .override(Target.SIZE_ORIGINAL))
                .into(imgProfilePhoto)

            tvProfileName.text = getString(R.string.textProfileName)
            tvProfileJobPosition.text = getString(R.string.textJobPosition)
            tvProfileEmail.text = getString(R.string.textEmail)
            tvProfileOffice.text = getString(R.string.textOfficeName)

            tvProfileLinkedIn.apply {
                text = getString(R.string.textLinkedIn)
                setTextColor(ContextCompat.getColor(this@ProfileActivity, R.color.teal_200))
            }

            tvProfileGithub.apply {
                text = getString(R.string.textGithub)
                setTextColor(ContextCompat.getColor(this@ProfileActivity, R.color.teal_200))
            }

            setAppVersion()
        }
    }

    private fun setInitOnClick() {
        binding.apply {
            tvProfileEmail.setOnClickListener(this@ProfileActivity)
            tvProfileLinkedIn.setOnClickListener(this@ProfileActivity)
            tvProfileGithub.setOnClickListener(this@ProfileActivity)
        }
    }

    private fun developerEmail() {
        binding.apply {
            val email = "yumtaufikhidayat@gmail.com"
            tvProfileEmail.makeLinks(Pair(email, View.OnClickListener {
                try {
                    val intentEmail = Intent(
                        Intent.ACTION_SENDTO,
                        Uri.fromParts("mailto", email, null)
                    ).apply {
                        putExtra(Intent.EXTRA_EMAIL, email)
                        putExtra(Intent.EXTRA_SUBJECT, "")
                        putExtra(Intent.EXTRA_TEXT, "")
                    }
                    startActivity(Intent.createChooser(intentEmail, "Send email:"))
                } catch (e: Exception) {
                    Toast.makeText(
                        this@ProfileActivity,
                        "Silakan install aplikasi email terlebih dulu",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e("errorEmail", "developerEmail: ${e.localizedMessage}")
                }
            }))
        }
    }

    private fun developerLinkedIn() {
        binding.apply {
            val linkedInUrl = "https://linkedin.com/in/taufik-hidayat"
            tvProfileLinkedIn.makeLinks(Pair(linkedInUrl, View.OnClickListener {
                try {
                    val intentLinkedIn = Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl))
                    startActivity(Intent.createChooser(intentLinkedIn, "Open with:"))
                } catch (e: Exception) {
                    Toast.makeText(this@ProfileActivity,
                        "Silakan install aplikasi browser terlebih dulu",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e("errorProject", "developerProject: ${e.localizedMessage}")
                }
            }))
        }
    }

    private fun developerGithub() {
        binding.apply {
            tvProfileGithub.makeLinks(Pair(githubUrl, View.OnClickListener {
                try {
                    val intentLinkedIn = Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl))
                    startActivity(Intent.createChooser(intentLinkedIn, "Buka dengan"))
                } catch (e: Exception) {
                    Toast.makeText(this@ProfileActivity,
                        "Silakan install aplikasi browser terlebih dulu",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e("errorProject", "developerProject: ${e.localizedMessage}")
                }
            }))
        }
    }

    private fun shareDeveloperProfile() {
        try {
            val body = "Visit this awesome user \n$githubUrl"
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, body)
            startActivity(Intent.createChooser(shareIntent, "Bagikan dengan"))
        } catch (e: Exception) {
            Log.e("shareFailed", "onOptionsItemSelected: ${e.localizedMessage}")
        }
    }

    private fun setAppVersion() {
        binding.apply {
            try {
                val pInfo: PackageInfo = packageManager.getPackageInfo(packageName, 0)
                val appVersion = pInfo.versionName
                tvVersion.text = String.format(getString(R.string.textAppVersion) + " " + appVersion)
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_profile, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.action_share -> shareDeveloperProfile()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvProfileEmail -> developerEmail()
            R.id.tvProfileLinkedIn -> developerLinkedIn()
            R.id.tvProfileGithub -> developerGithub()
        }
    }
}