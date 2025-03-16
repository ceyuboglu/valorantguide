package com.ceyuboglu.valorantguide.presentation.model

data class AgentDetailUiModel(
    val id: String,
    val name: String,
    val picUrl: String,
    val generalInfo: AgentGeneralInfoUiModel,
    val abilities: List<AbilityUiModel>
)

data class AgentGeneralInfoUiModel(
    val origin: String,
    val type: String,
    val ultimatePoints: String,
    val description: String
)

data class AbilityUiModel(
    val abilityName: String,
    val abilityType: String,
    val abilityCost: String,
    val abilityDescription: String
)