package com.ceyuboglu.valorantguide.agentslist

import com.ceyuboglu.valorantguide.domain.usecase.GetAgentsUseCase
import com.ceyuboglu.valorantguide.presentation.model.AgentUiModel
import com.ceyuboglu.valorantguide.presentation.ui.agents.AgentListViewModel
import com.ceyuboglu.valorantguide.presentation.ui.agents.AgentsUiState
import io.mockk.coEvery
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
class AgentListViewModelTest {

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
    fun `when getAgentsUseCase returns non-empty list, uiState becomes Success`() = runTest {
        val fakeAgent = AgentUiModel(id = "1", name = "Agent One", picUrl = "agentphoto1")
        val mockUseCase = mockk<GetAgentsUseCase>()
        coEvery { mockUseCase.invoke() } returns listOf(fakeAgent)

        val viewModel = AgentListViewModel(mockUseCase)

        testDispatcher.scheduler.advanceUntilIdle()

        when (val state = viewModel.uiState.value) {
            is AgentsUiState.Success -> assertEquals(listOf(fakeAgent), state.agentsUiModel)
            else -> throw AssertionError("Expected Success state but got $state")
        }
    }

    @Test
    fun `when getAgentsUseCase returns empty list, uiState becomes Error`() = runTest {
        val mockUseCase = mockk<GetAgentsUseCase>()
        coEvery { mockUseCase.invoke() } returns emptyList()

        val viewModel = AgentListViewModel(mockUseCase)

        testDispatcher.scheduler.advanceUntilIdle()

        assertTrue(viewModel.uiState.value is AgentsUiState.Error)
    }
}

