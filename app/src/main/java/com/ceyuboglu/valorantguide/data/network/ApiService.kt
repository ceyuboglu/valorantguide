package com.ceyuboglu.valorantguide.data.network

import com.ceyuboglu.valorantguide.data.model.AgentResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("agents")
    suspend fun getAgents() : Response<AgentResponseModel>

}