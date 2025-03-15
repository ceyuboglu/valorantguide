package com.ceyuboglu.valorantguide.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AgentResponseModel(
    @SerialName("status") var status: Int? = null,
    @SerialName("data") var data: ArrayList<Data> = arrayListOf()
)

@Serializable
data class Data(
    @SerialName("uuid") var uuid: String? = null,
    @SerialName("displayName") var displayName: String? = null,
    @SerialName("description") var description: String? = null,
    @SerialName("developerName") var developerName: String? = null,
    @SerialName("releaseDate") var releaseDate: String? = null,
    @SerialName("characterTags") var characterTags: String? = null,
    @SerialName("displayIcon") var displayIcon: String? = null,
    @SerialName("displayIconSmall") var displayIconSmall: String? = null,
    @SerialName("bustPortrait") var bustPortrait: String? = null,
    @SerialName("fullPortrait") var fullPortrait: String? = null,
    @SerialName("fullPortraitV2") var fullPortraitV2: String? = null,
    @SerialName("killfeedPortrait") var killfeedPortrait: String? = null,
    @SerialName("background") var background: String? = null,
    @SerialName("backgroundGradientColors") var backgroundGradientColors: ArrayList<String> = arrayListOf(),
    @SerialName("assetPath") var assetPath: String? = null,
    @SerialName("isFullPortraitRightFacing") var isFullPortraitRightFacing: Boolean? = null,
    @SerialName("isPlayableCharacter") var isPlayableCharacter: Boolean? = null,
    @SerialName("isAvailableForTest") var isAvailableForTest: Boolean? = null,
    @SerialName("isBaseContent") var isBaseContent: Boolean? = null,
    @SerialName("role") var role: Role? = Role(),
    @SerialName("recruitmentData") var recruitmentData: String? = null,
    @SerialName("abilities") var abilities: ArrayList<Abilities> = arrayListOf(),
    @SerialName("voiceLine") var voiceLine: String? = null
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