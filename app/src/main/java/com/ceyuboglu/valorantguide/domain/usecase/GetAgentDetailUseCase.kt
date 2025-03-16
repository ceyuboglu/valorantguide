package com.ceyuboglu.valorantguide.domain.usecase

import com.ceyuboglu.valorantguide.domain.repository.AgentsRepository
import javax.inject.Inject

class GetAgentDetailUseCase@Inject constructor(
    private val agentsRepository: AgentsRepository
) {

}