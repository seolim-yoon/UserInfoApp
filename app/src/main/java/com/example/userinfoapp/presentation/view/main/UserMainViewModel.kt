package com.example.userinfoapp.presentation.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userinfoapp.domain.model.DataModel
import com.example.userinfoapp.domain.usecase.GetUserInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserMainViewModel @Inject constructor(private val getUserInfoUseCase: GetUserInfoUseCase): ViewModel() {
    companion object {
        const val GET_QUERY = "shop"
    }

    private val _userInfoList = getUserInfoUseCase.getUserInfoListFromLocal()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)
    val userInfoList: StateFlow<List<DataModel>?>
        get() = _userInfoList

    init {
        viewModelScope.launch {
            getUserInfoUseCase.getUserInfoListFromRemote(GET_QUERY)
        }
    }
}

