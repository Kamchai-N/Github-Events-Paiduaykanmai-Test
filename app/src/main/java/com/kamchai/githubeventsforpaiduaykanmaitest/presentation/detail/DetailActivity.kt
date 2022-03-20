package com.kamchai.githubeventsforpaiduaykanmaitest.presentation.detail

import android.os.Build
import android.os.Bundle
import android.view.View.inflate
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import com.kamchai.githubeventsforpaiduaykanmaitest.R
import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.activity.BaseActivity
import com.kamchai.githubeventsforpaiduaykanmaitest.core.di.GlideApp
import com.kamchai.githubeventsforpaiduaykanmaitest.core.extension.context
import com.kamchai.githubeventsforpaiduaykanmaitest.core.extension.navigate
import com.kamchai.githubeventsforpaiduaykanmaitest.core.extension.onClick
import com.kamchai.githubeventsforpaiduaykanmaitest.core.extension.rfc3339ToStampDate
import com.kamchai.githubeventsforpaiduaykanmaitest.databinding.ActivityDetailBinding
import com.kamchai.githubeventsforpaiduaykanmaitest.databinding.ActivityDetailBinding.inflate
import com.kamchai.githubeventsforpaiduaykanmaitest.databinding.ActivityMainBinding
import com.kamchai.githubeventsforpaiduaykanmaitest.databinding.ItemCardBinding.inflate
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.entity.GitHubEventEntity
import com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main.MainActivity
import com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main.MainViewModel
import io.reactivex.rxkotlin.plusAssign
import timber.log.Timber

class DetailActivity : BaseActivity()  {
    private val viewModel: DetailViewModel by viewModels { factory }

    private val binding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val data = intent.getParcelableExtra<GitHubEventEntity>("data")
        viewModel.dataData(data)
        initListener()
        initObserver()
    }

    override fun initListener() {
        compositeDisposable += binding.back.onClick {
            navigate<MainActivity>(finishCurrent = true)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun initObserver() {
        viewModel.data.observe(this) {
            initViewProperties()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun initViewProperties(){
        val currencyData = viewModel.data.value
        binding.tvTitle.text = currencyData?.displayLogin
        binding.tvId.text = currencyData?.id.toString()
        binding.tvLogin.text = currencyData?.login
        binding.tvDisplayLogin.text = currencyData?.displayLogin
        binding.tvRepoName.text = currencyData?.repoName
        binding.tvCreatedAt.text = currencyData?.createdAt?.rfc3339ToStampDate()
        var gravatarId = currencyData?.gravatarId
        if (currencyData?.gravatarId.isNullOrEmpty()) {
            gravatarId = "-"
        }
        binding.tvGravatarId.text =  gravatarId
        GlideApp.with(this)
            .load(currencyData?.avatarUrl)
            .error(R.drawable.ic_avarta)
            .into(binding.ivCircleImageView)
    }
}