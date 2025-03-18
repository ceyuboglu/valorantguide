package com.ceyuboglu.valorantguide.agentslist

import com.ceyuboglu.valorantguide.data.model.AgentData
import com.ceyuboglu.valorantguide.domain.mapper.AgentsMapper
import com.ceyuboglu.valorantguide.domain.repository.AgentsRepository
import com.ceyuboglu.valorantguide.domain.usecase.GetAgentsUseCase
import com.ceyuboglu.valorantguide.presentation.model.AgentUiModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class GetAgentsUseCaseTest {

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `invoke returns mapped agents when repository returns non-empty list`() = runTest {
        val fakeAgentData = listOf(
            AgentData("1", "Agent One", "agentphoto1")
        )
        val expectedMapped = listOf(
            AgentUiModel("1", "Agent One", "agentphoto1")
        )
        val repository = mockk<AgentsRepository>()
        coEvery { repository.getAllAgents() } returns fakeAgentData
        val mapper = mockk<AgentsMapper>()
        every { mapper.map(fakeAgentData) } returns expectedMapped
        val useCase = GetAgentsUseCase(repository, mapper)

        val result = useCase.invoke()
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(expectedMapped, result)
    }

    @Test
    fun `invoke returns empty list when repository returns empty list`() = runTest {
        val repository = mockk<AgentsRepository>()
        coEvery { repository.getAllAgents() } returns emptyList()
        val mapper = mockk<AgentsMapper>()
        every { mapper.map(any<List<AgentData>>()) } returns emptyList()
        val useCase = GetAgentsUseCase(repository, mapper)

        val result = useCase.invoke()
        testDispatcher.scheduler.advanceUntilIdle()

        assertTrue(result.isEmpty())
    }
}