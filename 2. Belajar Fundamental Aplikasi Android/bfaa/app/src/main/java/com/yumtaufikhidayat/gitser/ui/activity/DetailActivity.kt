package com.yumtaufikhidayat.gitser.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.yumtaufikhidayat.gitser.R
import com.yumtaufikhidayat.gitser.data.User
import com.yumtaufikhidayat.gitser.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setParcelable()
        setToolbar()
        setData()
    }

    private fun setParcelable() {
        user = intent.getParcelableExtra<User>(EXTRA_PARCELABLE) as User
    }

    private fun setToolbar() {
        supportActionBar?.apply {
            title = user.username
            setDisplayHomeAsUpEnabled(true)
            elevation = 0F
        }
    }

    private fun setData() {
        binding.apply {
            Glide.with(this@DetailActivity)
                .load(user.profileImage)
                .apply(
                    RequestOptions()
                    .fitCenter()
                    .format(DecodeFormat.PREFER_ARGB_8888)
                    .override(Target.SIZE_ORIGINAL))
                .into(imgProfile)

            tvName.text = user.profileName
            tvUsername.text = user.username
            tvFollowingNumber.text = user.following.toString()
            tvFollowersNumber.text = user.followers.toString()
            tvRepositoryNumber.text = user.repositories.toString()
            tvLocation.text = user.location
            tvCompany.text = user.office
        }
    }

    private fun openInBrowser() {
        try {
            val link = user.profileLink
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(Intent.createChooser(intent, "Buka dengan"))
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "Silakan install peramban terlebih dahulu",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun shareUserProfile() {
        try {
            val body = "Kunjungi & bagikan profil pengguna ini \n${user.profileLink}"
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, body)
            startActivity(Intent.createChooser(shareIntent, "Bagikan dengan"))
        } catch (e: Exception) {
            Log.e("shareFailed", "onOptionsItemSelected: ${e.localizedMessage}")
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_detail, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            android.R.id.home -> onBackPressed()
//            R.id.action_open_in_browser -> openInBrowser()
//            R.id.action_share -> shareUserProfile()
//        }
//        return super.onOptionsItemSelected(item)
//    }

    companion object{
        const val EXTRA_PARCELABLE = "com.yumtaufikhidayat.gitser.ui.activity.EXTRA_PARCELABLE"
    }
}