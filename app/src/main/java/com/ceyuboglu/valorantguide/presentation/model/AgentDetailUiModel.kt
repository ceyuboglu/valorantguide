package com.ceyuboglu.valorantguide.presentation.model

data class AgentDetailUiModel(
    val name: String,
    val picUrl: String,
    val generalInfo: AgentGeneralInfoUiModel,
    val abilities: List<AbilityUiModel>
)

data class AgentGeneralInfoUiModel(
    val type: String?,
    val typeDescription: String?
)

data class AbilityUiModel(
    val abilityName: String,
    val abilityIcon: String,
    val abilityDescription: String
)