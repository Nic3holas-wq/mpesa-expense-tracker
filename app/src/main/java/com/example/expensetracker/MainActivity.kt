package com.example.expensetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.model.ExpenseDatabase
import com.example.expensetracker.model.repository.ExpenseRepository
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme
import com.example.expensetracker.view.AddExpenseScreen
import com.example.expensetracker.view.ExpenseListScreen
import com.example.expensetracker.view.Home
import com.example.expensetracker.view.Transactions
import com.example.expensetracker.viewmodel.ExpenseViewModel
import com.example.expensetracker.viewmodel.ExpenseViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = ExpenseRepository(ExpenseDatabase.getDatabase(this).expenseDao())

        // Use the ViewModelProvider to get the ViewModel instance
        val viewModel: ExpenseViewModel = ViewModelProvider(
            this,
            ExpenseViewModelFactory(application, repository)
        )[ExpenseViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            ExpenseTrackerTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "expense_list") {
                    composable("expense_list") {
                        ExpenseListScreen(viewModel, navController)
                    }
                    composable("add_expense") {
                        AddExpenseScreen(viewModel, navController)
                    }
                    composable("home"){
                        Home(navController)
                    }
                    composable("transactions"){
                        Transactions(navController)
                    }
                }
            }
        }
    }
}
