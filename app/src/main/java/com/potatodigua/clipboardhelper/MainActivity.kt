package com.potatodigua.clipboardhelper

import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.potatodigua.clipboardhelper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ClipboardManager.OnPrimaryClipChangedListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ClipboardUtils.addChangedListener(this)
    }

    override fun onResume() {
        super.onResume()
        binding.root.post {
            try {
                binding.clipboardContent.text = ClipboardUtils.text.toString().ifBlank { "剪贴板为空" }
//                val intent = Intent("clipper.get")
//                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP)
//                sendBroadcast(intent)
            } catch (e: Exception) {
                Log.e(localClassName, e.message, e)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        ClipboardUtils.removeChangedListener(this)
    }

    override fun onPrimaryClipChanged() {
        binding.clipboardContent.text = ClipboardUtils.text.toString().ifBlank { "剪贴板为空" }
    }
}