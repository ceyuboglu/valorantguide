package com.ceyuboglu.valorantguide.presentation.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.ceyuboglu.valorantguide.presentation.ui.AppTopBar

@Composable
fun HomeScreen(
    onNavigateToAgents: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            AppTopBar(
                title = "VALOGUIDE"
            )
        }
        items(3) {
            HomeMenuCard(
                onTap = onNavigateToAgents
            )
        }
    }
}

@Composable
private fun HomeMenuCard(
    onTap: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(horizontal = 18.dp, vertical = 24.dp)
            .clickable { onTap() },
        border = BorderStroke(1.dp, Color.Red),
        color = Color(0xff141E29)
    ) {
        Row(modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                text = "Agents",
                fontSize = 28.sp,
                color = Color.White
            )
            Box {
                Image(
                    modifier = Modifier.fillMaxHeight(),
                    painter = painterResource(id = R.drawable.homecardbg),
                    contentScale = ContentScale.Inside,
                    contentDescription = "Agent list"
                )
                Image(
                    modifier = Modifier.fillMaxHeight(),
                    painter = painterResource(id = R.drawable.agents),
                    contentScale = ContentScale.Inside,
                    contentDescription = "Agent list"
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen({})
}