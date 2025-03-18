package com.ceyuboglu.valorantguide.presentation.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
    val titles = listOf("AGENTS", "WEAPONS", "RANKS", "MAPS")
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        AppTopBar(
            title = "VALOGUIDE"
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically)
        ) {
            repeat(4) {
                HomeMenuCard(
                    title = titles[it],
                    isEnabled = it == 0,
                    onTap = onNavigateToAgents
                )
            }
        }
    }
}

@Composable
private fun HomeMenuCard(
    title: String,
    isEnabled: Boolean = false,
    onTap: () -> Unit
) {
    val backgroundColor = if (isEnabled) Color(0xff141E29) else Color(0xFF2C2C2C)
    val titleColor = if (isEnabled) Color.White else Color.LightGray

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(horizontal = 18.dp, vertical = 24.dp)
            .clickable(enabled = isEnabled) { onTap() },
        border = BorderStroke(1.dp, Color.Red),
        color = backgroundColor
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    text = title,
                    fontSize = 28.sp,
                    color = titleColor
                )
                Box {
                    Image(
                        modifier = Modifier.fillMaxHeight(),
                        painter = painterResource(id = R.drawable.homecardbg),
                        contentScale = ContentScale.Inside,
                        contentDescription = "Agent list background"
                    )
                    Image(
                        modifier = Modifier.fillMaxHeight(),
                        painter = painterResource(id = R.drawable.agents),
                        contentScale = ContentScale.Inside,
                        contentDescription = "Agent list overlay"
                    )
                }
            }
            if (!isEnabled) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 4.dp)
                        .graphicsLayer(rotationZ = -45f)
                        .background(Color(0xFF333333))
                ) {
                    Text(
                        text = "Soon",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen({})
}