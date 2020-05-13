package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Activity.hideKeyboard() {
    val view = this.currentFocus
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view?.windowToken, 0)
}

fun Activity.getRootView(): View {
    return findViewById<View>(android.R.id.content)
}
fun Context.convertDpToPx(dp: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        this.resources.displayMetrics
    )
}
fun Activity.isKeyboardOpen():Boolean
{
    var visibleBounds = Rect()
    this.findViewById<View>(android.R.id.content).getWindowVisibleDisplayFrame(visibleBounds)
    val heightDiff = this.findViewById<View>(android.R.id.content).height - visibleBounds.height ()
    val isOpen = heightDiff>0
    return isOpen
}

fun Activity.isKeyboardClosed():Boolean
{
    return !this.isKeyboardOpen()
}
