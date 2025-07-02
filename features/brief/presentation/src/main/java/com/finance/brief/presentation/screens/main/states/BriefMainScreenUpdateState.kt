package com.finance.brief.presentation.screens.main.states

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finance.brief.domain.models.Balance
import com.finance.brief.presentation.R
import com.finance.brief.presentation.screens.create.components.GreenTextField
import com.finance.common.ui.components.GrayDivider
import kotlinx.coroutines.launch

private var currencies = listOf(
    Pair("₽", "Российский рубль ₽"),
    Pair("$", "Американский доллар $"),
    Pair("€", "Евро €")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BriefMainScreenUpdateState(
    name: String,
    balance: String,
    currency: String,
    isDoneClicked: Boolean,
    onDoneClick: (Balance) -> Unit
) {

    var name by remember { mutableStateOf(name) }
    var balance by remember { mutableStateOf(balance) }
    var currency by remember { mutableStateOf(currency) }

    val currencyBState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(isDoneClicked) {
        if (isDoneClicked) {
            onDoneClick(
                Balance(
                    name = name,
                    formattedAmount = balance,
                    currency = currency
                )
            )
        }
    }

    if (currencyBState.isVisible){
        ModalBottomSheet(
            onDismissRequest = {
                scope.launch {
                    currencyBState.hide()
                }
            },
            modifier = Modifier,
            sheetState = currencyBState,
            shape = RoundedCornerShape(16.dp),
            containerColor = Color.White,
            contentColor = Color.Black,
        ) {
            Column() {
                currencies.forEach {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                            .clickable {
                                currency = it.first
                                scope.launch {
                                    currencyBState.hide()
                                }
                            }
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(it.first, fontSize = 24.sp)
                        Spacer(Modifier.width(15.dp))
                        Text(it.second, style = MaterialTheme.typography.bodyLarge)
                    }
                    if (currencies.indexOf(it) != currencies.lastIndex) {
                        GrayDivider()
                    }
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .background(Color(0xFFE46962))
                        .clickable {
                            scope.launch {
                                currencyBState.hide()
                            }
                        }
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painterResource(R.drawable.dicline_circle), "", tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(Modifier.width(15.dp))
                    Text("Отмена", style = MaterialTheme.typography.bodyLarge, color = Color.White)
                }
            }
        }
    }

    GreenTextField(
        placeholder = "Название счета",
        text = name,
        onChange = { name = it },
        isDigit = false,
        modifier = Modifier.fillMaxWidth()
    )

    GrayDivider()

    GreenTextField(
        placeholder = "Баланс",
        text = balance,
        onChange = { balance = it },
        isDigit = true,
        modifier = Modifier.fillMaxWidth()
    )

    GrayDivider()

    GreenTextField(
        placeholder = "Валюта",
        enabled = false,
        text = currency,
        onChange = { currency = it },
        isDigit = false,
        modifier = Modifier.fillMaxWidth().clickable{
            scope.launch {
                currencyBState.expand()
            }
        }
    )
}