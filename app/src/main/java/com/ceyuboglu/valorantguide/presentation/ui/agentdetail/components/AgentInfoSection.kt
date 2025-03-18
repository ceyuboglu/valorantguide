package com.ceyuboglu.valorantguide.presentation.ui.agentdetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceyuboglu.valorantguide.presentation.model.AgentGeneralInfoUiModel

@Composable
fun AgentInfoSection(infoUiModel: AgentGeneralInfoUiModel) {
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