package com.digi.composecalculator.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
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
    Box(
        modifier = modifier.padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row {
                OutlinedTextField(
                    value = uiState.num1,
                    onValueChange = { onEvent(MyEvent.OnNum1Entered(it)) },
                    label = { Text("Operand 1") },
                    placeholder = { Text("123") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
                OutlinedTextField(
                    value = uiState.num2,
                    onValueChange = { onEvent(MyEvent.OnNum2Entered(it)) },
                    label = { Text("Operand 2") },
                    placeholder = { Text("455") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = MaterialTheme.shapes.small
                    )
                    .height(if (uiState.ans.isEmpty()) 0.dp else 56.dp)
                    .animateContentSize()
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
                horizontalArrangement = Arrangement.Center
            ) {
                ActionButton(
                    onClickEvent = { onEvent(MyEvent.OnAddClicked) },
                    btnText = "Add",
                    icon = Icons.Default.Add
                )
            }
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ActionButton(
                    onClickEvent = { onEvent(MyEvent.OnMulClicked) },
                    btnText = "Mul",
                    icon = Icons.Default.Close
                )
                ActionButton(
                    onClickEvent = { onEvent(MyEvent.OnClearClicked) },
                    btnText = "Clear",
                    icon = Icons.Default.Delete
                )
                ActionButton(
                    onClickEvent = { onEvent(MyEvent.OnDivClicked) },
                    btnText = "Div",
                    icon = Icons.Default.Done
                )
            }
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                ActionButton(
                    onClickEvent = { onEvent(MyEvent.OnSubClicked) },
                    btnText = "Sub",
                    icon = Icons.Default.FavoriteBorder
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