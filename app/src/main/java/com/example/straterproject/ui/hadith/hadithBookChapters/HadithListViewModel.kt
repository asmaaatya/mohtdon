package com.example.straterproject.ui.hadith.hadithBookChapters

import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetSpecificHadithBookChaptersUseCase
import com.example.straterproject.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HadithListViewModel @Inject constructor(
    private val getSpecificHadithBookChaptersUseCase: GetSpecificHadithBookChaptersUseCase
) : BaseViewModel() {


    private val _hadithBookChaptersUiState = MutableStateFlow(HadithBookChaptersUiState())
    val hadithBookChaptersUiState = _hadithBookChaptersUiState.asStateFlow()


     fun collectSpecificHadithBookChapters(bookName:String ) {
        viewModelScope.launch {
            val bookChapters = getSpecificHadithBookChaptersUseCase.invoke(bookName)
            _hadithBookChaptersUiState.update {
                it.copy(
//                    specificBookChaptersList = bookChapters.bookChapters
                )
            }
        }
    }

}