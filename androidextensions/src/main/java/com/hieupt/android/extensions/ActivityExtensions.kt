package com.hieupt.android.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.MainThread
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

/**
 * Created by HieuPT on 9/4/2019.
 */
inline fun <reified T : Activity> Activity.startActivity(
    finished: Boolean = false,
    action: Intent.() -> Unit = {}
) {
    startActivity(Intent(this, T::class.java).apply(action))
    if (finished) {
        finish()
    }
}

inline fun <reified T : Activity> Activity.startActivityForResult(
    requestCode: Int,
    action: Intent.() -> Unit = {}
) {
    startActivityForResult(Intent(this, T::class.java).apply(action), requestCode)
}

fun Activity.finishActivityWithResult(resultCode: Int, action: Intent.() -> Unit = {}) {
    setResult(resultCode, Intent().apply(action))
    finish()
}

fun Activity.hideSoftInput() {
    currentFocus?.let {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

fun Activity.showSoftInput(view: View) {
    currentFocus?.let {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }
}

@MainThread
inline fun <reified VM : ViewModel> FragmentActivity.viewModels(
    noinline factoryProducer: (() -> ViewModelProvider.Factory)? = null
) = lazy { ViewModelProviders.of(this, factoryProducer?.invoke())[VM::class.java] }