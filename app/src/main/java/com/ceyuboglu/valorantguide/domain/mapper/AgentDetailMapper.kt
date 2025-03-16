package com.ceyuboglu.valorantguide.domain.mapper

import com.ceyuboglu.valorantguide.data.model.Abilities
import com.ceyuboglu.valorantguide.data.model.AgentDetailResponse
import com.ceyuboglu.valorantguide.data.model.Role
import com.ceyuboglu.valorantguide.domain.util.safeLet
import com.ceyuboglu.valorantguide.presentation.model.AbilityUiModel
import com.ceyuboglu.valorantguide.presentation.model.AgentDetailUiModel
import com.ceyuboglu.valorantguide.presentation.model.AgentGeneralInfoUiModel
import javax.inject.Inject

class AgentDetailMapper @Inject constructor() {

    fun map(agent: AgentDetailResponse): AgentDetailUiModel? {
        val agentName = agent.data?.displayName
        if (agentName.isNullOrBlank()) return null
        val uiModel = safeLet(
            agent.data?.abilities,
            agent.data?.fullPortrait,
            agent.data?.role
        ) { abilities, picUrl, role ->
            AgentDetailUiModel(
                name = agentName,
                picUrl = picUrl,
                abilities = abilities.mapToUiModel(),
                generalInfo = mapGeneralInfo(role)
            )
        }
        return uiModel
    }

    private fun ArrayList<Abilities>.mapToUiModel() : List<AbilityUiModel> {
       return this.map {
            safeLet(it.displayName,it.displayIcon,it.description) { name, icon, desc ->
                AbilityUiModel(
                    abilityName = name,
                    abilityIcon = icon,
                    abilityDescription = desc
                )
            }
        }.filterNotNull()
    }

    private fun mapGeneralInfo(role: Role) : AgentGeneralInfoUiModel {
        return AgentGeneralInfoUiModel(
            typeDescription = role.description,
            type = role.displayName,
        )
    }
}