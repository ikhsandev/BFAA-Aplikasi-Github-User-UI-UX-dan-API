package com.ikhsandicoding.submission02.viewModel

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ikhsandicoding.submission02.R
import com.ikhsandicoding.submission02.view.fragment.FragmentFollower
import com.ikhsandicoding.submission02.view.fragment.FragmentFollowing

class ViewPagerDetailAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val pages = listOf(
        FragmentFollowing(),
        FragmentFollower()
    )

    private val tabTitles = intArrayOf(
        R.string.follwing,
        R.string.follwer
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(tabTitles[position])
    }
}