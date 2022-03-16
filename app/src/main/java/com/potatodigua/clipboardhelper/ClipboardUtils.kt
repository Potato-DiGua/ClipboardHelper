package com.potatodigua.clipboardhelper

import android.content.ClipData
import android.content.ClipboardManager
import android.content.ClipboardManager.OnPrimaryClipChangedListener
import android.content.Context

object ClipboardUtils {
    /**
     * Copy the text to clipboard.
     *
     * The label equals name of package.
     *
     * @param text The text.
     */
    fun copyText(text: CharSequence?) {
        val cm = APP.INSTANCE.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        cm.setPrimaryClip(ClipData.newPlainText(APP.INSTANCE.getPackageName(), text))
    }

    /**
     * Copy the text to clipboard.
     *
     * @param label The label.
     * @param text  The text.
     */
    fun copyText(label: CharSequence?, text: CharSequence?) {
        val cm = APP.INSTANCE.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        cm.setPrimaryClip(ClipData.newPlainText(label, text))
    }

    /**
     * Clear the clipboard.
     */
    fun clear() {
        val cm = APP.INSTANCE.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        cm.setPrimaryClip(ClipData.newPlainText(null, ""))
    }

    /**
     * Return the label for clipboard.
     *
     * @return the label for clipboard
     */
    val label: CharSequence
        get() {
            val cm = APP.INSTANCE
                .getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val des = cm.primaryClipDescription ?: return ""
            return des.label ?: return ""
        }

    /**
     * Return the text for clipboard.
     *
     * @return the text for clipboard
     */
    val text: CharSequence
        get() {
            val cm =
                APP.INSTANCE.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = cm.primaryClip
            if (clip != null && clip.itemCount > 0) {
                val text = clip.getItemAt(0).coerceToText(APP.INSTANCE)
                if (text != null) {
                    return text
                }
            }
            return ""
        }

    /**
     * Add the clipboard changed listener.
     */
    fun addChangedListener(listener: OnPrimaryClipChangedListener?) {
        val cm = APP.INSTANCE.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        cm.addPrimaryClipChangedListener(listener)
    }

    /**
     * Remove the clipboard changed listener.
     */
    fun removeChangedListener(listener: OnPrimaryClipChangedListener?) {
        val cm = APP.INSTANCE.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        cm.removePrimaryClipChangedListener(listener)
    }
}