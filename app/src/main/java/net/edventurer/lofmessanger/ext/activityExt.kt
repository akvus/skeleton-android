package net.edventurer.lofmessanger.ext

import android.app.Activity
import android.support.design.widget.Snackbar

/**
 * Created by akvus on 2/19/18.
 */
fun Activity.snack(stringId: Int, length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(findViewById(android.R.id.content), stringId, length).show()
}