package com.example.thirtydaysapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thirtydaysapp.data.PushUp


@Composable
fun PushUpItem(pushUp: PushUp, dayNumber: Int, modifier: Modifier = Modifier) {
    val pushUpType = stringResource(pushUp.typeRes)
    val pushUpNumber = 100
    val itemText = "Day $dayNumber: $pushUpNumber $pushUpType"

    Card(
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Text(
                text = itemText,
                style = MaterialTheme.typography.bodyLarge,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(pushUp.imageRes),
                    contentDescription = pushUpType,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.small)
                        .background(color = Color.White)
                        .fillMaxHeight()
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PushUpItemPreview() {
    PushUpItem(
        pushUp = PushUp(typeRes = R.string.one_arm_supported_push_up, imageRes = R.drawable.one_arm_supported_push_ups),
        dayNumber = 1
    )
}