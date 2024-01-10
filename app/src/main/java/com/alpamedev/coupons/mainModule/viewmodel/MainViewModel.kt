package com.alpamedev.coupons.mainModule.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alpamedev.coupons.R
import com.alpamedev.coupons.common.entities.CouponEntity
import com.alpamedev.coupons.common.utils.getMessageError
import com.alpamedev.coupons.mainModule.model.MainRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repository = MainRepository()
    val coupon = MutableLiveData<CouponEntity>()
    private val _hideKeyboard = MutableLiveData<Boolean>()
    val hideKeyboard: LiveData<Boolean>
        get() = _hideKeyboard

    private val _snackBarMsg = MutableLiveData<Int>()
    val snackBarMessage: LiveData<Int>
        get() = _snackBarMsg

    fun getCouponByCode() {
        coupon.value?.code?.let {
            viewModelScope.launch {
                _hideKeyboard.value = true
                coupon.value = repository.getCouponByCode(it)
            }
        }
    }

    fun saveCoupon() {
        coupon.value?.let {
            viewModelScope.launch {
                _hideKeyboard.value = true
                try {
                    repository.insertCoupon(it)
                    getCouponByCode()
                    _snackBarMsg.value = R.string.main_save_success
                } catch (e: Exception) {
                    _snackBarMsg.value = getMessageError(e.message)
                }
            }
        }
    }
}