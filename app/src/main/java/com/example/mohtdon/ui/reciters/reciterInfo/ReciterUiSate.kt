package com.example.mohtdon.ui.reciters.reciterInfo


import com.example.domain.entity.reciters.ReciterEntity

data class ReciterUiSate(
    var isTabTitleVisible :Boolean = true,
    var isTabSearchVisible :Boolean = false,
    var searchText : String = "",
    var reciters : List<ReciterEntity> = emptyList(),
    var isLoading : Boolean  = false,
    var isError :Boolean = false,
    var errorMessage :String = "",
    var isDataExist  :Boolean = false
)