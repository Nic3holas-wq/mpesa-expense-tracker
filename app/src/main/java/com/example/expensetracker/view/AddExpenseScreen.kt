package com.example.expensetracker.view

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.expensetracker.model.Expense
import com.example.expensetracker.viewmodel.ExpenseViewModel
import java.time.LocalDate

@Composable
fun AddExpenseScreen(viewModel: ExpenseViewModel, navController: NavController) {
    var category by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Add New Expense", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Category") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val expenseAmount = amount.toDoubleOrNull()
                if (category.isNotEmpty() && expenseAmount != null) {
                    val currentDate = LocalDate.now().toString() // Get current date
                    viewModel.addExpense(Expense(category = category, amount = expenseAmount, date = currentDate))
                    Toast.makeText(context, "Expense Added!", Toast.LENGTH_SHORT).show()
                    navController.popBackStack() // Go back to previous screen
                } else {
                    Toast.makeText(context, "Please enter valid details!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Expense")
        }
    }
}

