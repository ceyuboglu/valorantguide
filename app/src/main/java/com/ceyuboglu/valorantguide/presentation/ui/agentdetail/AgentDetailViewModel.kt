package com.ceyuboglu.valorantguide.presentation.ui.agentdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ceyuboglu.valorantguide.domain.usecase.GetAgentDetailUseCase
import com.ceyuboglu.valorantguide.presentation.model.AgentDetailUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentDetailViewModel @Inject constructor(
    private val getAgentDetailUseCase: GetAgentDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<AgentDetailUiState>(AgentDetailUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun getData(agenId: String?) {
        viewModelScope.launch {
            agenId?.let {
                getAgentDetail(it)
            } ?: run {
                _uiState.emit(AgentDetailUiState.Error)
            }
        }
    }

    private suspend fun getAgentDetail(agentId: String) {
        val data = getAgentDetailUseCase.invoke(agentId)
        data?.let {
            _uiState.emit(AgentDetailUiState.Success(agentDetailUiModel = it))
        } ?: run {
            _uiState.emit(AgentDetailUiState.Error)

        }
    }

}

sealed class AgentDetailUiState {
    data object Loading : AgentDetailUiState()
    data object Error : AgentDetailUiState()
    data class Success(
        val agentDetailUiModel: AgentDetailUiModel
    ) : AgentDetailUiState()
}