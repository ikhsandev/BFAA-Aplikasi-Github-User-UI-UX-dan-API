package com.ikhsandicoding.submission02.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.ikhsandicoding.submission02.R
import com.ikhsandicoding.submission02.model.DataFollowers
import com.ikhsandicoding.submission02.model.DataUsers
import com.ikhsandicoding.submission02.viewModel.FollowerViewModel
import com.ikhsandicoding.submission02.viewModel.ListDataFollowerAdapter
import kotlinx.android.synthetic.main.fragment_follower.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentFollower : Fragment() {

    companion object {
        val TAG = FragmentFollower::class.java.simpleName
        const val EXTRA_DETAIL = "extra_detail"
    }

    private val listData: ArrayList<DataFollowers> = ArrayList()
    private lateinit var adapter: ListDataFollowerAdapter
    private lateinit var followerViewModel: FollowerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_follower, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ListDataFollowerAdapter(listData)
        followerViewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()
        ).get(FollowerViewModel::class.java)

        val dataUser = activity!!.intent.getParcelableExtra(EXTRA_DETAIL) as DataUsers
        config()

        followerViewModel.getDataGit(activity!!.applicationContext, dataUser.username.toString())
        showLoading(true)

        followerViewModel.getListFollower().observe(activity!!, Observer { listFollower ->
            if (listFollower != null) {
                adapter.setData(listFollower)
                showLoading(false)
            }
        })
    }

    private fun config() {
        recyclerViewFollowers.layoutManager = LinearLayoutManager(activity)
        recyclerViewFollowers.setHasFixedSize(true)
        recyclerViewFollowers.adapter = adapter
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressbarFollowers.visibility = View.VISIBLE
        } else {
            progressbarFollowers.visibility = View.INVISIBLE
        }
    }

}
