package com.ceyuboglu.valorantguide.domain.usecase

import com.ceyuboglu.valorantguide.domain.mapper.AgentsMapper
import com.ceyuboglu.valorantguide.domain.repository.AgentsRepository
import com.ceyuboglu.valorantguide.presentation.model.AgentUiModel
import javax.inject.Inject

class GetAgentsUseCase @Inject constructor(
    private val agentsRepository: AgentsRepository,
    private val agentsMapper: AgentsMapper
) {

    suspend fun invoke() : List<AgentUiModel> {
        val data = agentsRepository.getAllAgents()
        return if (data.isNotEmpty()) {
            agentsMapper.map(data)
        } else emptyList()
    }
}