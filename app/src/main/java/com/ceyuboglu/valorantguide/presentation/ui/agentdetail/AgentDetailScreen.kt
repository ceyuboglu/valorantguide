package com.ceyuboglu.valorantguide.presentation.ui.agentdetail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.ceyuboglu.valorantguide.presentation.model.AbilityUiModel
import com.ceyuboglu.valorantguide.presentation.model.AgentDetailUiModel
import com.ceyuboglu.valorantguide.presentation.model.AgentGeneralInfoUiModel
import com.ceyuboglu.valorantguide.presentation.ui.agentdetail.components.AgentAbilityCard
import com.ceyuboglu.valorantguide.presentation.ui.agentdetail.components.AgentDetailErrorScreen
import com.ceyuboglu.valorantguide.presentation.ui.agentdetail.components.AgentInfoSection
import com.ceyuboglu.valorantguide.presentation.ui.common.AppTopBar

@Composable
fun AgentDetailScreen(
    agentId: String?,
    onTapBack: () -> Unit
) {
    val viewModel: AgentDetailViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        viewModel.getData(agentId)
    }

    when (val state = viewModel.uiState.collectAsState().value) {
        AgentDetailUiState.Error -> AgentDetailErrorScreen(onTap = onTapBack)

        AgentDetailUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    modifier = Modifier.size(64.dp),
                    color = Color.Red,
                    strokeWidth = 8.dp
                )
            }
        }

        is AgentDetailUiState.Success -> AgentDetailSuccess(
            uiModel = state.agentDetailUiModel,
            onTapBack = onTapBack
        )
    }


}

@Composable
private fun AgentDetailSuccess(
    uiModel: AgentDetailUiModel,
    onTapBack: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            AppTopBar(
                title = uiModel.name,
                showBackButton = true,
                onBackClick = onTapBack
            )
        }
        item {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth(),
                model = uiModel.picUrl,
                contentDescription = "Agent Poster",
                contentScale = ContentScale.Fit,
                placeholder = painterResource(R.drawable.agentplaceholder)
            )
        }
        item {
            AgentInfoSection(uiModel.generalInfo)
        }
        items(uiModel.abilities.size) {
            AgentAbilityCard(uiModel.abilities[it])
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AgentDetailScreenPreview() {
    AgentDetailScreen("", {})
}