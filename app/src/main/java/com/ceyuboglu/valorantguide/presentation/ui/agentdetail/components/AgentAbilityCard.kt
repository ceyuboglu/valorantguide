package com.ceyuboglu.valorantguide.presentation.ui.agentdetail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ceyuboglu.valorantguide.R
import com.ceyuboglu.valorantguide.presentation.model.AbilityUiModel

@Composable
fun AgentAbilityCard(ability: AbilityUiModel) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 32.dp), border = BorderStroke(1.dp, Color.Red),
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
