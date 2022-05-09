package com.yumtaufikhidayat.gitser.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.yumtaufikhidayat.gitser.R
import com.yumtaufikhidayat.gitser.data.response.detail.DetailResponse
import com.yumtaufikhidayat.gitser.data.response.search.Search
import com.yumtaufikhidayat.gitser.data.viewmodel.detail.DetailViewModel
import com.yumtaufikhidayat.gitser.databinding.ActivityDetailBinding
import com.yumtaufikhidayat.gitser.utils.Utils.loadImage
import com.yumtaufikhidayat.gitser.utils.Utils.makeLinks

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var data: DetailResponse
    private lateinit var bundle: Bundle
    private lateinit var dataParcel: Search
    private lateinit var link: String
    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getParcelable()
        setToolbar()
        setBundleData()
        showDetailData()
    }

    private fun getParcelable() {
        dataParcel = intent.getParcelableExtra<Search>(EXTRA_PARCELABLE) as Search
    }

    private fun setBundleData() {
        bundle = Bundle()
        bundle.apply {
            putString(EXTRA_PARCELABLE, dataParcel.login)
        }
    }

    private fun setToolbar() {
        supportActionBar?.apply {
            title = dataParcel.login
            setDisplayHomeAsUpEnabled(true)
            elevation = 0F
        }
    }

    private fun showDetailData() {
        showLoading(true)
        binding.apply {
            detailViewModel.apply {
                setDetailData(dataParcel.login)
                getDetailData().observe(this@DetailActivity) { detail ->
                    data = detail

                    imgProfile.loadImage(detail.avatarUrl)
                    tvName.text = detail.name
                    tvUsername.text = detail.login
                    tvFollowingNumber.text = detail.following.toString()
                    tvFollowersNumber.text = detail.followers.toString()
                    tvRepositoryNumber.text = detail.publicRepos.toString()

                    if (detail.location.isNullOrBlank() || detail.company.isNullOrBlank()) {
                        link = ""
                        tvLocation.text = "-"
                        tvCompany.text = "-"
                        tvLink.text = "-"
                    } else {
                        link = detail.blog
                        tvLocation.text = detail.location
                        tvCompany.text = detail.company
                        tvLink.text = link
                    }

                    tvLink.makeLinks(Pair(link, View.OnClickListener {
                        try {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                            startActivity(Intent.createChooser(intent, "Buka dengan"))
                        } catch (e: java.lang.Exception) {
                            Toast.makeText(
                                this@DetailActivity,
                                "Silakan menginstall browser terlebih dahulu.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }))
                    showLoading(false)
                }
            }
        }
    }

    private fun setPagerData() = with(binding) {

    }

    private fun openInBrowser() {
        try {
            val link = data.htmlUrl
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
            val body = "Kunjungi & bagikan profil pengguna ini \n${data.htmlUrl}"
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, body)
            }
            startActivity(Intent.createChooser(shareIntent, "Bagikan dengan"))
        } catch (e: Exception) {
            Log.e("shareFailed", "onOptionsItemSelected: ${e.localizedMessage}")
        }
    }

    private fun showLoading(isShow: Boolean) = with(binding) {
        if (isShow) {
            shimmerLoadingDetail.visibility = View.VISIBLE
        } else {
            shimmerLoadingDetail.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.action_open_in_browser -> openInBrowser()
            R.id.action_share -> shareUserProfile()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object{
        const val EXTRA_PARCELABLE = "com.yumtaufikhidayat.gitser.ui.activity.EXTRA_PARCELABLE"
    }
}