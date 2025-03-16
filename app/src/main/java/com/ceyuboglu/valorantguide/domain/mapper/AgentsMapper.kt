package com.ceyuboglu.valorantguide.domain.mapper

import com.ceyuboglu.valorantguide.data.model.AgentData
import com.ceyuboglu.valorantguide.domain.util.safeLet
import com.ceyuboglu.valorantguide.presentation.model.AgentUiModel
import javax.inject.Inject

class AgentsMapper @Inject constructor() {

    fun map(agents: List<AgentData>): List<AgentUiModel> {
        val uiModel = agents.map { agentResponse ->
            safeLet(
                agentResponse.uuid,
                agentResponse.displayName,
                agentResponse.bustPortrait
            ) { id, name, picUrl ->
                AgentUiModel(
                    id = id,
                    name = name,
                    picUrl = picUrl
                )
            }
        }
        return uiModel.filterNotNull()
    }
}