package com.kamchai.githubeventsforpaiduaykanmaitest.core.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.time.Instant
import java.util.*
import java.util.concurrent.TimeUnit


fun View.onClick(delay: Int = 1, action: (view: View) -> Unit): Disposable =
    RxView.clicks(this)
        .throttleFirst(delay.toLong(), TimeUnit.SECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            action.invoke(this)
        }, {
            Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
        })

fun TextView.onTextChange(delay: Int = 0, action: (String) -> Unit): Disposable =
    RxTextView.textChanges(this)
        .skipInitialValue()
        .debounce(delay.toLong(), TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            action.invoke(it.toString())
        }, {
            Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
        })
//
//fun Activity.finishWithHideKeyboard() {
//    hideKeyboard()
//    finish()
//}
//
//fun String.rfc3339ToParkingDate(): String = try {
//    val calendar = Calendar.getInstance()
//    calendar.timeInMillis = Instant.parse(this).toEpochMilli()
//    val hour = calendar.get(Calendar.HOUR_OF_DAY)
//    val minute = calendar.get(Calendar.MINUTE)
//    val date = calendar.get(Calendar.DATE)
//    val time = "${if (hour < 10) "0${hour}" else hour}.${if (minute < 10) "0${minute}" else minute}"
//    val shortDate = if (date < 10) "0${date}" else "$date"
//    val month = calendar.get(Calendar.MONTH) + 1
//    val shortMonth = if (month < 10) "0${month}" else "$month"
//    val shortYear = calendar.get(Calendar.YEAR) + 543
//    "$shortDate/$shortMonth/${shortYear}, $time"
//} catch (exception: Exception) {
//    "-"
//}
//
//fun String.rfc3339ToParkingDay(): String = try {
//    val calendar = Calendar.getInstance()
//    calendar.timeInMillis = Instant.parse(this).toEpochMilli()
//    val date = calendar.get(Calendar.DATE)
//    val shortDate = if (date < 10) "0${date}" else "$date"
//    val month = calendar.get(Calendar.MONTH) + 1
//    val shortMonth = if (month < 10) "0${month}" else "$month"
//    val shortYear = calendar.get(Calendar.YEAR) + 543
//    "$shortDate/$shortMonth/${shortYear}"
//} catch (exception: Exception) {
//    "-"
//}
//
//fun String.rfc3339ToParkingTime(): String = try {
//    val calendar = Calendar.getInstance()
//    calendar.timeInMillis = Instant.parse(this).toEpochMilli()
//    val hour = calendar.get(Calendar.HOUR_OF_DAY)
//    val minute = calendar.get(Calendar.MINUTE)
//    "${if (hour < 10) "0${hour}" else hour}:${if (minute < 10) "0${minute}" else minute}"
//} catch (exception: Exception) {
//    Timber.e(exception.message ?: ERROR_NO_MESSAGE)
//    "-"
//}

//fun <T : BaseViewEntity> BaseViewHolder<T>.drawable(@DrawableRes id: Int?): Drawable? = id?.run {
//    ResourcesCompat.getDrawable(context().resources, this, null)
//}
//
//fun BaseFragment.drawable(@DrawableRes id: Int?): Drawable? = id?.run {
//    ResourcesCompat.getDrawable(resources, this, null)
//}
//
//fun BaseActivity.drawable(@DrawableRes id: Int?): Drawable? = id?.run {
//    ResourcesCompat.getDrawable(resources, this, null)
//}


@RequiresApi(Build.VERSION_CODES.O)
fun String.rfc3339ToStampDate(): String = try {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = Instant.parse(this).toEpochMilli()
    val date = calendar.get(Calendar.DATE)
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)
    val shortDate = if (date < 10) "0${date}" else "$date"
    val month = calendar.get(Calendar.MONTH) + 1
    val shortMonth = if (month < 10) "0${month}" else "$month"
    val shortYear = calendar.get(Calendar.YEAR) + 543
    "$shortDate/$shortMonth/${shortYear} " +
            "${if (hour < 10) "0${hour}" else hour}.${if (minute < 10) "0${minute}" else minute}"
} catch (exception: Exception) {
    "-"
}
//
//fun MutableLiveData<List<RecyclerItemViewEntity>>.loadingx() {
//    postValue(listOf(LoadingViewXEntity(isLoading = true)))
//}
//
//fun MutableLiveData<List<RecyclerItemViewEntity>>.refreshx(action: () -> Unit = {}) {
//    postValue(listOf(LoadingViewXEntity(isLoading = false, refreshAction = action)))
//}

fun String.toToken() = "token $this"

fun View.forceShowKeyboard() {
    requestFocus()
    val manager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    manager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0)
}

inline fun <reified T : Activity> Activity.navigate(
    options: Bundle? = null,
    finishCurrent: Boolean = false,
    startForResult: Boolean = false,
    requestCode: Int = 0,
    intentBody: Intent.() -> Unit = {}
) {
    val intent = Intent(this, T::class.java)
    intent.intentBody()
    if (startForResult) startActivityForResult(intent, requestCode, options)
    else startActivity(intent, options)
    if (finishCurrent) finishAfterTransition()
}

fun Activity.toast(message: String? = null) {
    Toast.makeText(this, "$message", Toast.LENGTH_LONG).show()
}

fun RecyclerView.ViewHolder.context(): Context = itemView.context

fun RecyclerView.ViewHolder.string(id: Int) = context().getString(id)

