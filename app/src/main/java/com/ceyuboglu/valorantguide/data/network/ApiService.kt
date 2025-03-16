package com.ceyuboglu.valorantguide.data.network

import com.ceyuboglu.valorantguide.data.model.AgentDetailResponse
import com.ceyuboglu.valorantguide.data.model.AgentResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("agents")
    suspend fun getAgents(): Response<AgentResponseModel>

    @GET("agents/{agentId}")
    suspend fun getAgentDetail(@Path("agentId") agentId: String): Response<AgentDetailResponse>

}