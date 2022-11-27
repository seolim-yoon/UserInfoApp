package com.example.userinfoapp.presentation.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userinfoapp.domain.model.DataModel
import com.example.userinfoapp.domain.usecase.GetUserInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserMainViewModel @Inject constructor(private val getUserInfoUseCase: GetUserInfoUseCase): ViewModel() {
    companion object {
        const val GET_QUERY = "shop"
    }

    private val _userInfoList = MutableStateFlow<List<DataModel>?>(null)
    val userInfoList: StateFlow<List<DataModel>?>
        get() = _userInfoList

    init {
        getUserInfoListFromRemote()
    }

    private fun getUserInfoListFromRemote() {
        viewModelScope.launch {
            getUserInfoUseCase.getUserInfoListFromRemote(GET_QUERY).collect {
                getUserInfoListFromLocal()
            }
        }
    }

    private fun getUserInfoListFromLocal() {
        viewModelScope.launch {
            getUserInfoUseCase.getUserInfoListFromLocal().collect {
                _userInfoList.value = it
            }
        }
    }
}

