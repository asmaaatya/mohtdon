package com.example.data.dataSource.remote.response.hadith.chapters

data class Chapter(
    val bookSlug: String,
    val chapterArabic: String,
    val chapterEnglish: String,
    val chapterNumber: String,
    val chapterUrdu: String,
    val id: Int
)