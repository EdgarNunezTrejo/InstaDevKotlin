package com.eddev.instadev.data.di

import com.eddev.instadev.data.repository.AuthRepositoryImpl
import com.eddev.instadev.domain.repositories.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideAuthRepository (): AuthRepository{
        return AuthRepositoryImpl()
    }
}