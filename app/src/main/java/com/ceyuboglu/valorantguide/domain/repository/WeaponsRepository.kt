package com.ceyuboglu.valorantguide.domain.repository

interface WeaponsRepository {

    suspend fun getAllWeapons()

    suspend fun getWeaponDetail(weaponId: String)
}