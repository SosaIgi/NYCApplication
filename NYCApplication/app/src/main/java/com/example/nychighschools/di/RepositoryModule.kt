package com.example.20230215-EsosaseheIgiehon-nycSchools.di

import com.example.20230215-EsosaseheIgiehon-nycSchools.repository.Repository
import com.example.20230215-EsosaseheIgiehon-nycSchools.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun getRepository(repository: RepositoryImpl): Repository
}