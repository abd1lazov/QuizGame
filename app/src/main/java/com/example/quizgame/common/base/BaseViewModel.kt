package com.example.quizgame.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizgame.common.resource.Resource
import com.example.quizgame.state.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> loadData(
        data: MutableStateFlow<UIState<T>>,
        request: () -> Flow<Resource<T>>
    ) {
        viewModelScope.launch {
            request().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        data.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        resource.data?.let {
                            data.value = UIState.Success(it)
                        }
                    }
                    is Resource.Error -> {
                        resource.message?.let {
                            data.value = UIState.Error(it)
                        }
                    }
                }
            }
        }
    }
}