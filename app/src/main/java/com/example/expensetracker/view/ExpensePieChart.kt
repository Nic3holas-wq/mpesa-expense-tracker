package com.example.expensetracker.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.expensetracker.model.Expense

@Composable
fun ExpensePieChart(expenses: List<Expense>){
    val categoryTotals = expenses.groupBy { it.category }
        .mapValues { it.value.sumOf { expense -> expense.amount } }

    val colors = listOf(Color.Red, Color.Blue, Color.Green, Color.Yellow, Color.Cyan)
    var startAngle = 0f
    val totalAmount = categoryTotals.values.sum()

    Canvas(modifier = Modifier.size(200.dp)) {
        categoryTotals.entries.forEachIndexed { index, entry ->
            val sweepAngle = (entry.value / totalAmount * 360).toFloat()
            drawArc(
                color = colors[index % colors.size],
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = true
            )
            startAngle +=sweepAngle
        }
    }
}