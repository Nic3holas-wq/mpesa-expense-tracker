package com.example.expensetracker.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.expensetracker.viewmodel.ExpenseViewModel

@Composable
fun ExpenseListScreen(viewModel: ExpenseViewModel, navController: NavController) {
    val expenses = viewModel.allExpenses.collectAsState(initial = emptyList()).value


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("home") }
            ) {
                Text("+") // Add expense button
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            if (expenses.isNotEmpty()) {
                ExpensePieChart(expenses)
                Spacer(modifier = Modifier.height(16.dp))
                ExpenseBarChart(expenses)
            }

            LazyColumn {
                items(expenses) { expense ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = "Category: ${expense.category}")
                            Text(text = "Amount: Ksh ${expense.amount}")
                        }
                    }
                }
            }
        }
    }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        if (expenses.isNotEmpty()) {
            ExpensePieChart(expenses)
            Spacer(modifier = Modifier.height(16.dp))
            ExpenseBarChart(expenses)
        }
        LazyColumn {
            items(expenses) { expense ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Category: ${expense.category}")
                        Text(text = "Amount: Ksh ${expense.amount}")
                    }
                }
            }
        }
    }
}
