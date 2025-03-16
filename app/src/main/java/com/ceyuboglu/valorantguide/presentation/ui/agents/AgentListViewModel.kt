package com.ceyuboglu.valorantguide.presentation.ui.agents

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ceyuboglu.valorantguide.domain.usecase.GetAgentsUseCase
import com.ceyuboglu.valorantguide.presentation.model.AgentUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentListViewModel @Inject constructor(
    private val getAgentsUseCase: GetAgentsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<AgentsUiState>(AgentsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getAgents()
        }
    }

    private suspend fun getAgents() {
        val data = getAgentsUseCase.invoke()
        if (data.isNotEmpty()) {
            _uiState.emit(AgentsUiState.Success(agentsUiModel = data))
        } else {
            _uiState.emit(AgentsUiState.Error)
        }
    }

}


sealed class AgentsUiState {
    data object Loading : AgentsUiState()
    data object Error : AgentsUiState()
    data class Success(
        val agentsUiModel: List<AgentUiModel>
    ) : AgentsUiState()
}