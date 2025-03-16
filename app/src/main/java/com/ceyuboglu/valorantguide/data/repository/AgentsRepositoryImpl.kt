package com.ceyuboglu.valorantguide.data.repository

import android.util.Log
import com.ceyuboglu.valorantguide.data.model.AgentData
import com.ceyuboglu.valorantguide.data.model.AgentDetailResponse
import com.ceyuboglu.valorantguide.data.network.ApiService
import com.ceyuboglu.valorantguide.domain.repository.AgentsRepository
import javax.inject.Inject

class AgentsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : AgentsRepository {

    override suspend fun getAllAgents(): List<AgentData> {
        try {
            val result = apiService.getAgents()
            if (result.isSuccessful) {
                return result.body()?.data ?: emptyList()
            } else return emptyList()
        } catch (e: Exception) {
            Log.e("Exception", e.message.toString())
            return emptyList()
        }
    }

    override suspend fun getAgentDetail(agentId: String) : AgentDetailResponse? {
        try {
            val result = apiService.getAgentDetail(agentId)
            if (result.isSuccessful) {
                return result.body()
            } else return null
        } catch (e: Exception) {
            Log.e("Exception", e.message.toString())
            return null
        }
    }

}