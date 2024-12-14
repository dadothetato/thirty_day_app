package com.example.thirtydaysapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaysapp.data.PushUp
import com.example.thirtydaysapp.data.PushUpRepository


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PushUpTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = modifier
    )
}


@Composable
fun PushUpApp() {
    Scaffold(
        topBar = {
            PushUpTopAppBar()
        }
    ) {
        LazyColumn(contentPadding = it) {
            itemsIndexed(PushUpRepository.pushUps) { index, pushUp ->
                PushUpItem(
                    pushUp = pushUp,
                    dayNumber = index + 1,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PushUpItem(pushUp: PushUp, dayNumber: Int, modifier: Modifier = Modifier) {
    val pushUpType = stringResource(pushUp.typeRes)
    val pushUpNumber = 100
    val itemText = "Day $dayNumber: $pushUpNumber $pushUpType"
    var isChecked by remember { mutableStateOf(false) }

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
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = itemText,
                    style = MaterialTheme.typography.bodyLarge,
                )
                CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = {
                            isChecked = !isChecked
                        }
                    )
                }
            }
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
                        .fillMaxSize()
                )
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun PushUpItemPreview() {
    PushUpItem(
        pushUp = PushUp(typeRes = R.string.one_arm_supported_push_up, imageRes = R.drawable.one_arm_supported_push_ups),
        dayNumber = 1
    )
}
 */

@Preview(showBackground = true)
@Composable
fun PushUpAppPreview() {
    PushUpApp()
}