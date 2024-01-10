package com.alpamedev.coupons.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alpamedev.coupons.R
import com.alpamedev.coupons.common.entities.CouponEntity
import com.alpamedev.coupons.common.utils.hideKeyboard
import com.alpamedev.coupons.databinding.ActivityMainBinding
import com.alpamedev.coupons.mainModule.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView<ActivityMainBinding?>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
            viewmodel = mainViewModel
        }

        setUpObservers()
    }

    private fun setUpObservers() {
        mainBinding.viewmodel?.let { vm->
            vm.coupon.observe(this@MainActivity) { coupon ->
                mainBinding.isActive = coupon != null && coupon.isActive
            }
            vm.snackBarMessage.observe(this@MainActivity) {
                Snackbar.make(mainBinding.root,getString(it),Snackbar.LENGTH_SHORT).show()
            }
            vm.hideKeyboard.observe(this@MainActivity) {
                if (it) hideKeyboard(this, mainBinding.root)
            }
        }
    }
}