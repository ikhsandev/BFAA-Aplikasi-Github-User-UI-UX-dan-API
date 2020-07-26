package com.ikhsandicoding.submission02.view

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ikhsandicoding.submission02.R
import com.ikhsandicoding.submission02.model.DataUsers
import com.ikhsandicoding.submission02.viewModel.ViewPagerDetailAdapter
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            viewpager.layoutParams.height = resources.getDimension(R.dimen.height).toInt()
        } else {
            viewpager.layoutParams.height = resources.getDimension(R.dimen.height1).toInt()
        }

        if (supportActionBar != null) {
            supportActionBar?.title = "Detail User"
        }
        setData()
        viewPagerConfig()


    }

    private fun viewPagerConfig() {
        val viewPagerDetail = ViewPagerDetailAdapter(this, supportFragmentManager)
        viewpager.adapter = viewPagerDetail
        tabs.setupWithViewPager(viewpager)
        supportActionBar?.elevation = 0f
    }

    private fun setData() {
        val dataUser = intent.getParcelableExtra(EXTRA_DETAIL) as DataUsers
        Glide.with(this)
            .load(dataUser.avatar)
            .apply(RequestOptions().override(150, 130))
            .into(avatars)
        fullName.text = dataUser.name
        username.text = getString(R.string.user, dataUser.username)
        company.text = dataUser.company
        location.text = dataUser.location
        following.text = dataUser.following
        followers.text = dataUser.followers
        repositories.text = dataUser.repository
    }


}
