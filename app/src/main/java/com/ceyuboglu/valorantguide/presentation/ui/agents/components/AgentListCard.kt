package com.ceyuboglu.valorantguide.presentation.ui.agents.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.ceyuboglu.valorantguide.R
import com.ceyuboglu.valorantguide.presentation.model.AgentUiModel

@Composable
fun AgentCard(modifier: Modifier, uiModel: AgentUiModel, onTap: (id: String) -> Unit) {
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
