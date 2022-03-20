package com.kamchai.githubeventsforpaiduaykanmaitest.core.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.state.ViewState
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()

    val dialogState: MutableLiveData<ViewState> = MutableLiveData()

    val loadingState: MutableLiveData<Unit> = MutableLiveData()

    val normalState: MutableLiveData<Unit> = MutableLiveData()

    fun setNormalState() {
        normalState.postValue(Unit)
    }

    fun setLoadingState() {
        loadingState.postValue(Unit)
    }

    fun setSuccessState(
        message: String,
        dismissAction: () -> Unit = {},
        title: String? = null
    ) {
        dialogState.postValue(ViewState.Success(message, dismissAction, title))
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}