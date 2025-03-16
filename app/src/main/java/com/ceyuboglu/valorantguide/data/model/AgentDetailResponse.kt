package com.ceyuboglu.valorantguide.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AgentDetailResponse(
    @SerialName("data") var data: AgentData? = null
)