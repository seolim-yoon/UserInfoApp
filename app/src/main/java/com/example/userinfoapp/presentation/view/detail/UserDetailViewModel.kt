package com.example.userinfoapp.presentation.view.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userinfoapp.domain.usecase.PostUserHeartUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val postUserHeartUserCase: PostUserHeartUserCase
): ViewModel() {
    private val _userHeartState = MutableStateFlow(false)
    val userHeartState: StateFlow<Boolean>
        get() = _userHeartState

    fun postUserHeartState(id: Int) {
        _userHeartState.value = _userHeartState.value.not()

        viewModelScope.launch(Dispatchers.IO) {
            postUserHeartUserCase.postUserHeartState(id, _userHeartState.value)
        }
    }

    fun setUserHeartState(heart: Boolean) {
        _userHeartState.value = heart
    }
}