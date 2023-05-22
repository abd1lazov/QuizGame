package com.example.quizgame.ui.fragments.home

import com.example.quizgame.common.base.BaseViewModel
import com.example.quizgame.domain.entities.CategoryEntity
import com.example.quizgame.domain.useCases.game.GetCategoryUseCase
import com.example.quizgame.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel@Inject constructor(private val getCategoryUseCase: GetCategoryUseCase): BaseViewModel() {

    private val categoryList = MutableStateFlow<UIState<List<CategoryEntity>>>(UIState.Loading())

    val categoryList_: StateFlow<UIState<List<CategoryEntity>>>get() = categoryList

    init {
        chooseCategory()
    }

    private fun chooseCategory(){
        loadData(categoryList){
            getCategoryUseCase()
        }
    }

}