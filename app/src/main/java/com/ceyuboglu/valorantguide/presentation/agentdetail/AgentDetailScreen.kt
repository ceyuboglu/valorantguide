package com.ceyuboglu.valorantguide.presentation.agentdetail

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceyuboglu.valorantguide.R

@Composable
fun AgentDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.brimstonedetail),
            contentScale = ContentScale.Inside,
            contentDescription = "Agent list"
        )
        AgentInfoSection()
        AgentAbilitiesSecition()
    }
}

@Composable
private fun AgentAbilitiesSecition() {
    repeat(3) {
        AgentAbilityCard()
    }
}

@Composable
private fun AgentAbilityCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(174.dp),
        border = BorderStroke(1.dp, Color.Red),
        color = Color(0xff141E29)
    ) {
        Column {
            Text(text = "Incendiary", color = Color.Red)
            Row {
                Spacer(modifier = Modifier.width(34.dp))
                Column {
                    Text(text = "Type", color = Color.Red)
                    Text(text = "Cost", color = Color.Red)
                }
            }
            Text(text = "Description", color = Color.Red)
        }
    }
}

@Composable
private fun AgentInfoSection() {
    //bu varsa bu olsun checki ile ilerlenecek
    AgentInfoSectionItem()
}

@Composable
private fun AgentInfoSectionItem() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "ORIGIN", color = Color.Red, fontSize = 12.sp)
        Text(text = "UNITED STATES", color = Color.White, fontSize = 12.sp)
    }
}


@Preview(showBackground = true)
@Composable
private fun AgentDetailScreenPreview() {
    AgentDetailScreen()
}