package com.ceyuboglu.valorantguide.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AgentResponseModel(
    @SerialName("status") var status: Int? = null,
    @SerialName("data") var data: ArrayList<AgentData> = arrayListOf()
)

@Serializable
data class AgentData(
    @SerialName("uuid") var uuid: String? = null,
    @SerialName("displayName") var displayName: String? = null,
    @SerialName("description") var description: String? = null,
    @SerialName("releaseDate") var releaseDate: String? = null,
    @SerialName("bustPortrait") var bustPortrait: String? = null,
    @SerialName("fullPortrait") var fullPortrait: String? = null,
    @SerialName("isBaseContent") var isBaseContent: Boolean? = null,
    @SerialName("role") var role: Role? = Role(),
    @SerialName("abilities") var abilities: ArrayList<Abilities> = arrayListOf(),
)

@Serializable
data class Role(
    @SerialName("uuid") var uuid: String? = null,
    @SerialName("displayName") var displayName: String? = null,
    @SerialName("description") var description: String? = null,
    @SerialName("displayIcon") var displayIcon: String? = null,
    @SerialName("assetPath") var assetPath: String? = null
)

@Serializable
data class Abilities(
    @SerialName("slot") var slot: String? = null,
    @SerialName("displayName") var displayName: String? = null,
    @SerialName("description") var description: String? = null,
    @SerialName("displayIcon") var displayIcon: String? = null
)