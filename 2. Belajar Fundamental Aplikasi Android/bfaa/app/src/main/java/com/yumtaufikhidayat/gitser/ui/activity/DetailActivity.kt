package com.yumtaufikhidayat.gitser.ui.activity

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.yumtaufikhidayat.gitser.R
import com.yumtaufikhidayat.gitser.data.response.detail.DetailResponse
import com.yumtaufikhidayat.gitser.data.response.search.Search
import com.yumtaufikhidayat.gitser.data.viewmodel.detail.DetailViewModel
import com.yumtaufikhidayat.gitser.databinding.ActivityDetailBinding
import com.yumtaufikhidayat.gitser.ui.adapter.PagerAdapter
import com.yumtaufikhidayat.gitser.utils.Utils.loadImage
import com.yumtaufikhidayat.gitser.utils.Utils.makeLinks
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        setBundleData()
        initToolbar()
        checkThemes()
        initObserver()
        showDetailData()
        setPagerData()
        saveToFavorite()
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

    private fun initToolbar() {
        supportActionBar?.apply {
            title = dataParcel.login
            setDisplayHomeAsUpEnabled(true)
            elevation = 0F
        }
    }

    private fun checkThemes() = with(binding){
        when (this@DetailActivity.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {
                viewFirstLayer.background = ContextCompat.getDrawable(this@DetailActivity, R.drawable.first_layer_black)
                tvName.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvUsername.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvFollowingNumber.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvFollowing.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvFollowersNumber.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvFollowers.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvRepositoryNumber.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvRepository.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvLocation.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvCompany.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
            }

            Configuration.UI_MODE_NIGHT_NO -> {
                viewFirstLayer.background = ContextCompat.getDrawable(this@DetailActivity, R.drawable.first_layer_white)
                tvName.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.black))
                tvUsername.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.black))
                tvFollowingNumber.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvFollowing.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvFollowersNumber.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvFollowers.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvRepositoryNumber.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvRepository.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.white))
                tvLocation.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.black))
                tvCompany.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.black))
            }
        }
    }

    private fun initObserver() {
        detailViewModel.isLoading.observe(this) {
            showLoading(it)
        }
    }

    private fun showDetailData() {
        binding.apply {
            detailViewModel.apply {
                setDetailData(dataParcel.login)
                detailInfoData.observe(this@DetailActivity) { detail ->
                    data = detail
                    imgProfile.loadImage(detail.avatarUrl)
                    tvName.text = detail.name ?: "-"
                    tvUsername.text = detail.login ?: "-"
                    tvFollowingNumber.text = detail.following.toString()
                    tvFollowersNumber.text = detail.followers.toString()
                    tvRepositoryNumber.text = detail.publicRepos.toString()
                    tvLocation.text = detail.location ?: "-"
                    tvCompany.text = detail.company ?: "-"
                    tvLink.text = detail.blog.ifEmpty {
                        "-"
                    }
                    link = tvLink.text.toString()

                    tvLink.makeLinks(Pair(link, View.OnClickListener {
                        try {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                            startActivity(Intent.createChooser(intent, "Buka dengan"))
                        } catch (e: java.lang.Exception) {
                            Toast.makeText(
                                this@DetailActivity,
                                getString(R.string.tvInstallBrowser),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }))
                }
            }
        }
    }

    private fun saveToFavorite() = with(binding) {
        var isChecked = false
        CoroutineScope(Dispatchers.IO).launch {
            val count = detailViewModel.checkUserFavorite(dataParcel.id)
            withContext(Dispatchers.Main) {
                if (count != null) {
                    if (count > 0) {
                        toggleFavoriteDetailSearch.isChecked = true
                        isChecked = true
                    } else {
                        toggleFavoriteDetailSearch.isChecked = false
                        isChecked = false
                    }
                }
            }
        }

        toggleFavoriteDetailSearch.setOnClickListener {
            isChecked = !isChecked
            if (isChecked) {
                detailViewModel.addToFavorite(
                    dataParcel.id,
                    dataParcel.login,
                    dataParcel.avatarUrl,
                    dataParcel.type
                )
                showToast("Ditambahkan ke favorit")
            } else {
                detailViewModel.removeFromFavorite(dataParcel.id)
                showToast("Dihapus dari favorit")
            }

            toggleFavoriteDetailSearch.isChecked = isChecked
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun setPagerData() = with(binding) {
        val pagerAdapter = PagerAdapter(this@DetailActivity, bundle)
        viewPagerDetail.adapter = pagerAdapter
        TabLayoutMediator(tabLayoutDetail, viewPagerDetail) { tabs, position ->
            tabs.text = resources.getString(tabTitles[position])
        }.attach()
    }

    private fun openInBrowser() {
        try {
            val link = data.htmlUrl
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(Intent.createChooser(intent, "Buka dengan"))
        } catch (e: Exception) {
            Toast.makeText(
                this,
                getString(R.string.tvInstallBrowser),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun shareUserProfile() {
        try {
            val body = String.format("%s \n%s", getString(R.string.tvVisitAndShare), data.htmlUrl)
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, body)
            }
            startActivity(Intent.createChooser(shareIntent, "Bagikan dengan"))
        } catch (e: Exception) {
            Log.e(TAG, "onOptionsItemSelected: ${e.localizedMessage}")
        }
    }

    private fun showLoading(isShow: Boolean) = with(binding) {
        if (isShow) {
            shimmerLoadingDetail.visibility = View.VISIBLE
            layoutDetailVisibility.visibility = View.GONE
        } else {
            shimmerLoadingDetail.visibility = View.GONE
            layoutDetailVisibility.visibility = View.VISIBLE
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
        private val TAG = DetailActivity::class.java.simpleName
        @StringRes
        private val tabTitles = intArrayOf(
            R.string.tvFollowing,
            R.string.tvFollowers,
            R.string.tvRepository
        )
    }
}