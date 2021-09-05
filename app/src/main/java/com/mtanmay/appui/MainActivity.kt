package com.mtanmay.appui

import android.os.Bundle
import android.view.Gravity
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.alpha
import com.mtanmay.appui.databinding.ActivityMainBinding
import com.mtanmay.appui.databinding.ToolbarOptionsBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarLayout.toolbar)

        val optionsBinding = ToolbarOptionsBinding.bind(binding.root)

        optionsBinding.apply {

            questionerLocation.setOnClickListener() {
                showPopUp(optionsBinding)
            }

        }
        binding.root.foreground.alpha = 0

    }

    private fun showPopUp(optionsBinding: ToolbarOptionsBinding) {

        val popupView = layoutInflater.inflate(R.layout.layout_popup_window, null)
        popupView.animation = AnimationUtils.loadAnimation(this, R.anim.popoup_anim)

        val focusable = true

        val popupWindow = PopupWindow(popupView, 1000, LinearLayout.LayoutParams.WRAP_CONTENT, focusable)
        popupWindow.showAtLocation(optionsBinding.questionerLocation, Gravity.TOP, 0, 150)
        binding.root.foreground.alpha = 220

        popupWindow.setOnDismissListener {
            binding.root.foreground.alpha = 0
        }

    }
}