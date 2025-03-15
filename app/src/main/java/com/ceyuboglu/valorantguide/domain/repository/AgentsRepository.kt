package com.ceyuboglu.valorantguide.domain.repository

interface AgentsRepository {

    suspend fun getAllAgents()

    suspend fun getAgentDetail(agentId: String)

}