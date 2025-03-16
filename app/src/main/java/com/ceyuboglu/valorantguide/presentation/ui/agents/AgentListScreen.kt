package com.ceyuboglu.valorantguide.presentation.ui.agents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.ceyuboglu.valorantguide.R
import com.ceyuboglu.valorantguide.presentation.model.AgentUiModel
import com.ceyuboglu.valorantguide.presentation.ui.AppTopBar

@Composable
fun AgentListScreen(
    onNavigateToAgentDetail: (id: String) -> Unit,
    onTapBack: () -> Unit
) {
    val viewModel: AgentListViewModel = hiltViewModel()
    when (val state = viewModel.uiState.collectAsState().value) {
        AgentsUiState.Error -> {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(text = "We're having a trouble to call agents. Please try later")
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(50.dp),
                    onClick = onTapBack
                ) {
                    Text(text = "Back")
                }
            }
        }

        AgentsUiState.Loading -> {
            CircularProgressIndicator()
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

@Composable
private fun AgentCard(modifier: Modifier, uiModel: AgentUiModel, onTap: (id: String) -> Unit) {

    Surface(
        modifier = modifier
            .height(260.dp)
            .width(150.dp)
            .padding(horizontal = 18.dp, vertical = 12.dp)
            .clickable { onTap(uiModel.id) },
        border = BorderStroke(1.dp, Color.Red),
        color = Color(0xff141E29)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier,
                textAlign = TextAlign.Center,
                text = uiModel.name,
                fontSize = 16.sp,
                color = Color.White
            )
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth(),
                model = uiModel.picUrl,
                contentDescription = "Agent Image",
                contentScale = ContentScale.Fit,
                placeholder = painterResource(R.drawable.agentplaceholder)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AgentListScreenPreview() {
    AgentListScreen({}, {})
}