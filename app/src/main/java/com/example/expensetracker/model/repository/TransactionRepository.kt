package com.example.expensetracker.model.repository

import androidx.lifecycle.LiveData
import com.example.expensetracker.model.Transaction
import com.example.expensetracker.model.TransactionDao
import kotlinx.coroutines.flow.Flow

class TransactionRepository(private val transactionDao: TransactionDao) {
    fun getAllTransactions(): Flow<List<Transaction>> = transactionDao.getAllTransactions()

    suspend fun insert(transaction: Transaction){
        transactionDao.insertTransaction(transaction)
    }

    suspend fun delete(transaction: Transaction){
        transactionDao.deleteTransaction(transaction)
    }

    fun getTotalSent(): Flow<Double?> {
        return transactionDao.getTotalSent()
    }

    fun getTotalReceived(): Flow<Double?> {
        return transactionDao.getTotalReceived()
    }

    fun getBalance(): Flow<Double?> {
        return transactionDao.getBalance()
    }

    fun getExpensesByDateRange(startDate: Long, endDate: Long): LiveData<List<Transaction>> {
        return transactionDao.getExpensesBetween(startDate, endDate)
    }
}