package com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.activity.BaseActivity
import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.recyclerview.BaseAdapter
import com.kamchai.githubeventsforpaiduaykanmaitest.core.extension.navigate
import com.kamchai.githubeventsforpaiduaykanmaitest.databinding.ActivityMainBinding
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.entity.GitHubEventEntity
import com.kamchai.githubeventsforpaiduaykanmaitest.presentation.detail.DetailActivity
import com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main.item_github_events.ItemEmergencyViewRender
import timber.log.Timber

class MainActivity : BaseActivity()  , MainListener {
    private val viewModel: MainViewModel by viewModels { factory }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViewProperties()
        initObserver()
    }

    override fun initViewProperties() {
        binding.recyclerview.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerview.adapter = adapter
    }

    private val adapter by lazy {
        BaseAdapter(this, compositeDisposable).apply {
//            registerRenderer(LoadingViewRenderer())
            registerRenderer(ItemEmergencyViewRender())
        }
    }

    override fun initObserver() {
        viewModel.data.observe(this) {
            adapter.submitList(it)
        }
    }

    override fun onItemClicked(gitHub: GitHubEventEntity) {
        Timber.d(" kamchai_n : $gitHub")
        navigate<DetailActivity>(startForResult = false) {
            this.putExtra("data",  gitHub)
        }
    }
}