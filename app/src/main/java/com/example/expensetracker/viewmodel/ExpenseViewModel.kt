package com.example.expensetracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensetracker.model.Expense
import com.example.expensetracker.model.ExpenseDatabase
import com.example.expensetracker.model.repository.ExpenseRepository
import kotlinx.coroutines.launch

class ExpenseViewModel(application: Application, private val repository: ExpenseRepository) : AndroidViewModel(application) {

    val allExpenses =  repository.getAllExpenses()

    fun addExpense(expense: Expense){
        viewModelScope.launch{
            repository.insert(expense)
        }
    }
}
