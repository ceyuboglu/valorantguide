package com.ceyuboglu.valorantguide.domain.usecase

import com.ceyuboglu.valorantguide.domain.mapper.AgentDetailMapper
import com.ceyuboglu.valorantguide.domain.repository.AgentsRepository
import com.ceyuboglu.valorantguide.presentation.model.AgentDetailUiModel
import javax.inject.Inject

class GetAgentDetailUseCase@Inject constructor(
    private val agentsRepository: AgentsRepository,
    private val agentDetailMapper: AgentDetailMapper
) {
    suspend fun invoke(agentId: String) : AgentDetailUiModel? {
        val data = agentsRepository.getAgentDetail(agentId)
        return if (data != null) {
            agentDetailMapper.map(data)
        } else null
    }
}