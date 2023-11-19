package com.digi.composecalculator.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.digi.composecalculator.ui.MyEvent
import com.digi.composecalculator.ui.MyUiState
import com.digi.composecalculator.ui.theme.ComposeCalculatorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalcScreen(
    uiState: MyUiState,
    onEvent: (MyEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Column {
            Row(
                modifier = Modifier.background(color = Color.LightGray)
            ) {
                TextField(
                    value = uiState.num1,
                    onValueChange = { onEvent(MyEvent.onNum1Entered(it)) },
                    label = { Text("Operand 1") },
                    placeholder = { Text("123") },
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
                TextField(
                    value = uiState.num2,
                    onValueChange = { onEvent(MyEvent.onNum2Entered(it)) },
                    label = { Text("Operand 2") },
                    placeholder = { Text("455") },
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
            }
            Row(
                modifier = Modifier.background(color = Color.LightGray)
            ) {
                Text(
                    text = uiState.ans,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(1f)
                )
            }
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ActionButton(
                    onClickEvent = { onEvent(MyEvent.onAddClicked) },
                    btnText = "Add",
                    icon = Icons.Default.Add
                )
                ActionButton(
                    onClickEvent = { onEvent(MyEvent.onSubClicked) },
                    btnText = "Sub",
                    icon = Icons.Default.FavoriteBorder
                )
                ActionButton(
                    onClickEvent = { onEvent(MyEvent.onMulClicked) },
                    btnText = "Mul",
                    icon = Icons.Default.Close
                )
                ActionButton(
                    onClickEvent = { onEvent(MyEvent.onDivClicked) },
                    btnText = "Div",
                    icon = Icons.Default.Done
                )
            }
        }
    }
}


@Composable
fun ActionButton(
    onClickEvent: () -> Unit,
    btnText: String,
    icon: ImageVector
) {
    IconButton(
        onClick = onClickEvent,
        modifier = Modifier.background(
            color = MaterialTheme.colorScheme.primary,
            shape = MaterialTheme.shapes.small
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = btnText,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
fun CalcScreenPreview() {
    ComposeCalculatorTheme {
        CalcScreen(
            uiState = MyUiState(),
            onEvent = {}
        )
    }
}