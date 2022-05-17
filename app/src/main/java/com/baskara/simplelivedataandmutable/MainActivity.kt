package com.baskara.simplelivedataandmutable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.baskara.simplelivedataandmutable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory("Counter Result", 0)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
        viewModel.readTitle.observe(this, Observer {
            binding.textTitle.text = it.toString()
        })
        viewModel.readResult.observe(this, Observer {
            binding.textResult.text = it.toString()
        })

        binding.apply {

            buttonPlus.setOnClickListener {
                viewModel.setPlus(editInput.text.toString().toInt())
            }

            buttonMinus.setOnClickListener {
                viewModel.setMinus(editInput.text.toString().toInt())
            }

            buttonTimes.setOnClickListener {
                viewModel.setTimes(editInput.text.toString().toInt())
            }

            buttonDivide.setOnClickListener {
                viewModel.setDivide(editInput.text.toString().toInt())
            }
        }

    }
}