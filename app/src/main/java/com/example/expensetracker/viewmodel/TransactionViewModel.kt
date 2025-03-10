package com.example.expensetracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.expensetracker.model.Transaction
import com.example.expensetracker.model.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.util.Calendar

class TransactionViewModel(application: Application, private val repository: TransactionRepository): AndroidViewModel(application) {
    val allTransactions = repository.getAllTransactions()
    val totalSent: Flow<Double?> = repository.getTotalSent()
    val totalReceived: Flow<Double?> = repository.getTotalReceived()
    val totalBalance: Flow<Double?> = repository.getBalance()

    fun addTransaction(transaction: Transaction){
        viewModelScope.launch{
            repository.insert(transaction)
        }
    }

    fun getReport(period: String): LiveData<List<Transaction>> {
        val calendar = Calendar.getInstance()
        val endDate = calendar.timeInMillis

        val startDate = when(period) {
            "daily" -> calendar.apply { add(Calendar.DAY_OF_YEAR, -1) }.timeInMillis
            "weekly" -> calendar.apply { add(Calendar.WEEK_OF_YEAR, -1) }.timeInMillis
            "monthly" -> calendar.apply { add(Calendar.MONTH, -1) }.timeInMillis
            "yearly" -> calendar.apply { add(Calendar.YEAR, -1) }.timeInMillis
            else -> return MutableLiveData(emptyList())
        }
        return repository.getExpensesByDateRange(startDate, endDate)
    }


}