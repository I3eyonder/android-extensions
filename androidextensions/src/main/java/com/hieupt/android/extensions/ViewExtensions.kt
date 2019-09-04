package com.hieupt.android.extensions

import android.view.View

/**
 * Created by HieuPT on 9/5/2019.
 */
fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}