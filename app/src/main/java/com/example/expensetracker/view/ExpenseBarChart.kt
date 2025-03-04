package com.example.expensetracker.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Canvas
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.expensetracker.model.Expense

@Composable
fun ExpenseBarChart(expenses: List<Expense>) {
    val categoryTotals = expenses.groupBy { it.category }
        .mapValues { it.value.sumOf { expense -> expense.amount } }

    val maxAmount = categoryTotals.values.maxOrNull() ?: 1.0
    val colors = listOf(Color.Red, Color.Blue, Color.Green, Color.Yellow, Color.Cyan)

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        categoryTotals.entries.forEachIndexed { index, (category, amount) ->
            val barWidth = (amount / maxAmount * 250).toFloat()

            Row(modifier = Modifier.padding(vertical = 4.dp)) {
                Text(text = category, modifier = Modifier.width(100.dp))
                Canvas(modifier = Modifier.width(barWidth.dp).height(20.dp)) {
                    drawRoundRect(
                        color = colors[index % colors.size],
                        size = size,
                        cornerRadius = CornerRadius(8f, 8f)
                    )
                }
                Text(text = "Ksh ${amount.toInt()}", modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}
