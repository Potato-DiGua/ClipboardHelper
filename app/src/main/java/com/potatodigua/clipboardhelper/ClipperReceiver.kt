package com.potatodigua.clipboardhelper

import android.app.Activity
import android.content.*
import android.util.Log
import android.widget.Toast

/*
 * Receives broadcast commands and controls clipboard accordingly.
 * The broadcast receiver is active only as long as the application, or its service is active.
 */
class ClipperReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(
            APP.INSTANCE,
            if (APP.isAppForeground) R.string.has_received else R.string.background_tip,
            Toast.LENGTH_SHORT
        ).show()
        if (isActionSet(intent.action)) {
            Log.d(TAG, "Setting text into clipboard")
            val text = intent.getStringExtra(EXTRA_TEXT)
            if (text != null) {
                ClipboardUtils.copyText(text)
                resultCode = Activity.RESULT_OK
                resultData = "Text is copied into clipboard."
            } else {
                resultCode = Activity.RESULT_CANCELED
                resultData = "No text is provided. Use -e text \"text to be pasted\""
            }
        } else if (isActionGet(intent.action)) {
            Log.d(TAG, "Getting text from clipboard")
            val clip = ClipboardUtils.text.toString()
            if (clip.isNotEmpty()) {
                Log.d(
                    TAG,
                    "Clipboard text: $clip"
                )
                resultCode = Activity.RESULT_OK
                resultData = clip
            } else {
                resultCode = Activity.RESULT_CANCELED
                resultData = ""
            }
        }
    }

    companion object {
        private const val TAG = "ClipboardReceiver"
        private const val ACTION_GET = "clipper.get"
        private const val ACTION_SET = "clipper.set"
        private const val EXTRA_TEXT = "text"

        fun isActionGet(action: String?): Boolean {
            return ACTION_GET == action
        }

        fun isActionSet(action: String?): Boolean {
            return ACTION_SET == action
        }
    }
}