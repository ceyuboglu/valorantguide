package com.ceyuboglu.valorantguide.domain.repository

import com.ceyuboglu.valorantguide.data.model.AgentData

interface AgentsRepository {

    suspend fun getAllAgents() : List<AgentData>

    suspend fun getAgentDetail(agentId: String)

}