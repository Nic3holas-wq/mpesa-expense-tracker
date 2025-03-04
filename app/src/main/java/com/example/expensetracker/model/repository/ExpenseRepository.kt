package com.example.expensetracker.model.repository

import com.example.expensetracker.model.Expense
import com.example.expensetracker.model.ExpenseDao
import kotlinx.coroutines.flow.Flow

class ExpenseRepository(private val expenseDao: ExpenseDao) {
    fun getAllExpenses(): Flow<List<Expense>> = expenseDao.getAllExpenses()

    suspend fun insert(expense: Expense){
        expenseDao.insertExpense(expense)
    }

    suspend fun delete(expense: Expense){
        expenseDao.deleteExpense(expense)
    }

}