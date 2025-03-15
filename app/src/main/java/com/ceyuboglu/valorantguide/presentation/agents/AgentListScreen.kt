package com.ceyuboglu.valorantguide.presentation.agents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceyuboglu.valorantguide.R

@Composable
fun AgentListScreen() {
    val agentList = listOf("jett","sove","raze","omen","breach")
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(agentList.chunked(2).size) { index ->
            Row(modifier = Modifier.fillMaxWidth()) {
                agentList.chunked(2).get(index).forEach {
                    AgentCard(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun AgentCard(modifier: Modifier) {
    Surface(
        modifier = modifier
            .height(260.dp)
            .width(150.dp)
            .padding(horizontal = 18.dp, vertical = 24.dp),
        border = BorderStroke(1.dp, Color.Red),
        color = Color(0xff141E29)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier,
                textAlign = TextAlign.Center,
                text = "Jett",
                fontSize = 16.sp,
                color = Color.White
            )
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.jett),
                contentScale = ContentScale.Inside,
                contentDescription = "Agent list"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AgentListScreenPreview() {
    AgentListScreen()
}