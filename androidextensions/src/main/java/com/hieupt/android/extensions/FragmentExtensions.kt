package com.hieupt.android.extensions

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment

/**
 * Created by HieuPT on 9/4/2019.
 */
inline fun <reified T : Activity> Fragment.startActivity(action: Intent.() -> Unit = {}) {
    startActivity(Intent(context, T::class.java).apply(action))
}

inline fun <reified T : Activity> Fragment.startActivityForResult(
    requestCode: Int,
    action: Intent.() -> Unit = {}
) {
    startActivityForResult(Intent(context, T::class.java).apply(action), requestCode)
}