package com.ceyuboglu.valorantguide.di

import com.ceyuboglu.valorantguide.data.repository.AgentsRepositoryImpl
import com.ceyuboglu.valorantguide.domain.repository.AgentsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPostRepository(
        agentsRepository: AgentsRepositoryImpl
    ): AgentsRepository

}