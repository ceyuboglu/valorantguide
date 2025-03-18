package com.ceyuboglu.valorantguide.agentslist

import com.ceyuboglu.valorantguide.data.model.AgentData
import com.ceyuboglu.valorantguide.domain.mapper.AgentsMapper
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class AgentsMapperTest {

    private lateinit var mapper: AgentsMapper

    @Before
    fun setup() {
        mapper = AgentsMapper()
    }

    @Test
    fun `map returns correct ui model when input is valid`() {
        val agentData = AgentData(
            uuid = "1",
            displayName = "Agent One",
            bustPortrait = "https://example.com/portrait.png"
        )

        val result = mapper.map(listOf(agentData))

        assertEquals(1, result.size)
        val uiModel = result.first()
        assertEquals("1", uiModel.id)
        assertEquals("Agent One", uiModel.name)
        assertEquals("https://example.com/portrait.png", uiModel.picUrl)
    }

    @Test
    fun `map filters out agents with missing fields`() {
        val validAgent = AgentData(
            uuid = "1",
            displayName = "Agent One",
            bustPortrait = "photo1"
        )
        val invalidAgent = AgentData(
            uuid = null,
            displayName = "Agent Two",
            bustPortrait = "photo2"
        )

        val result = mapper.map(listOf(validAgent, invalidAgent))

        assertEquals(1, result.size)
        val uiModel = result.first()
        assertEquals("1", uiModel.id)
        assertEquals("Agent One", uiModel.name)
        assertEquals("photo1", uiModel.picUrl)
    }

    @Test
    fun `map returns empty list when input is empty`() {
        val agentList = emptyList<AgentData>()

        val result = mapper.map(agentList)

        assertTrue(result.isEmpty())
    }
}
