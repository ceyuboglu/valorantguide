package com.ceyuboglu.valorantguide.presentation.ui.agentdetail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.ceyuboglu.valorantguide.presentation.ui.AppTopBar

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
        AgentDetailUiState.Error -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 18.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Agent not responding the call.\nPlease try later",
                    color = Color.White
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    ),
                    border = BorderStroke(1.dp, Color.Red),
                    onClick = onTapBack
                ) {
                    Text(text = "Back")
                }
            }
        }
        AgentDetailUiState.Loading -> CircularProgressIndicator()
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


@Composable
private fun AgentAbilityCard(ability: AbilityUiModel) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 32.dp)
,        border = BorderStroke(1.dp, Color.Red),
        color = Color(0xff141E29)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .weight(0.3f),
                    model = ability.abilityIcon,
                    contentDescription = "Ability Icon",
                    contentScale = ContentScale.Fit,
                    placeholder = painterResource(R.drawable.agentplaceholder)
                )
                Text(modifier = Modifier.weight(1f), text = ability.abilityName, color = Color.Red)
            }
            Text(
                modifier = Modifier,
                text = ability.abilityDescription,
                color = Color.White
            )
        }
    }
}

@Composable
private fun AgentInfoSection(infoUiModel: AgentGeneralInfoUiModel) {
    Column(
        modifier = Modifier.padding(32.dp)
    ) {
        infoUiModel.type?.let { type ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "TYPE", color = Color.Red, fontSize = 12.sp)
                Text(text = type, color = Color.White, fontSize = 12.sp)
            }
        }
        infoUiModel.typeDescription?.let { desc ->
            Column {
                Text(text = "Description", color = Color.Red, fontSize = 12.sp)
                Text(text = desc, color = Color.White, fontSize = 12.sp)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun AgentDetailScreenPreview() {
    AgentDetailScreen("", {})
}