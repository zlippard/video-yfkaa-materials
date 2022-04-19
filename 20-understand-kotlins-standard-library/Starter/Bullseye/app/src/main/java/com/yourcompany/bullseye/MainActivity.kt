package com.yourcompany.bullseye

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog
import com.yourcompany.bullseye.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private var sliderValue = 0
  
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.hitMeButton.setOnClickListener {
      Log.i("Button Click Event", "You clicked the Hit Me Button")
      showResult()
    }
    
    binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
      override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        sliderValue = progress
      }

      override fun onStartTrackingTouch(seekBar: SeekBar?) {}

      override fun onStopTrackingTouch(seekBar: SeekBar?) {}

    })

  }

  private fun showResult() {
    val dialogTitle = getString(R.string.result_dialog_title)
    val dialogMessage = getString(R.string.result_dialog_message, sliderValue)
//    val dialogMessage = "The slider's value is $sliderValue"

    val builder = AlertDialog.Builder(this)

    builder.setTitle(dialogTitle)
    builder.setMessage(dialogMessage)
    builder.setPositiveButton(R.string.result_dialog_button_text) {dialog, _ ->
      dialog.dismiss()
    }

    builder.create().show()
  }
}








