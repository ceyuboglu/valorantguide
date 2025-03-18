package com.ceyuboglu.valorantguide.presentation.ui.agents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ceyuboglu.valorantguide.presentation.model.AgentUiModel
import com.ceyuboglu.valorantguide.presentation.ui.common.AppTopBar
import com.ceyuboglu.valorantguide.presentation.ui.agents.components.AgentCard
import com.ceyuboglu.valorantguide.presentation.ui.agents.components.AgentListErrorScreen

@Composable
fun AgentListScreen(
    onNavigateToAgentDetail: (id: String) -> Unit,
    onTapBack: () -> Unit
) {
    val viewModel: AgentListViewModel = hiltViewModel()
    when (val state = viewModel.uiState.collectAsState().value) {
        AgentsUiState.Error -> AgentListErrorScreen(onTap = onTapBack)

        AgentsUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    modifier = Modifier.size(64.dp),
                    color = Color.Red,
                    strokeWidth = 8.dp
                )
            }
        }

        is AgentsUiState.Success -> AgentListSuccessScreen(
            data = state.agentsUiModel,
            onTapBack = onTapBack,
            onNavigateToAgentDetail = onNavigateToAgentDetail
        )
    }

}

@Composable
private fun AgentListSuccessScreen(
    data: List<AgentUiModel>,
    onTapBack: () -> Unit,
    onNavigateToAgentDetail: (id: String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            AppTopBar(
                title = "AGENTS",
                showBackButton = true,
                onBackClick = onTapBack
            )
        }
        items(data.chunked(2).size) { index ->
            Row(modifier = Modifier.fillMaxWidth()) {
                data.chunked(2).get(index).forEach {
                    AgentCard(
                        modifier = Modifier.weight(1f),
                        uiModel = it,
                        onTap = onNavigateToAgentDetail
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AgentListScreenPreview() {
    AgentListScreen({}, {})
}