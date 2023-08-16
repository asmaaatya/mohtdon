package com.example.straterproject.di

import com.example.data.dataSource.remote.QuranRepositoryImpl
import com.example.domain.repo.QuranRepository
import com.example.domain.repo.SurahRepository
import com.example.domain.usecases.GetAllReciterUseCase
import com.example.domain.usecases.GetAllSurahUseCase
import com.example.domain.usecases.GetSurahAyahsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCas( quranRepository: QuranRepository ):GetAllReciterUseCase {
        return GetAllReciterUseCase(quranRepository)
    }
    @Provides
    fun provideSurahUseCase(surahRepository: SurahRepository):GetAllSurahUseCase{
        return GetAllSurahUseCase(surahRepository)
    }
    @Provides
    fun provideAyahUseCase(surahRepository: SurahRepository):GetSurahAyahsUseCase{
        return GetSurahAyahsUseCase(surahRepository)
    }

}