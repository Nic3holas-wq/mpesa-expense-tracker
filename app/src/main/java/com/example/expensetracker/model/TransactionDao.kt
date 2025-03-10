package com.example.expensetracker.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    @Query("SELECT * FROM transactions ORDER BY date DESC, time DESC")
    fun getAllTransactions(): Flow<List<Transaction>>

    @Query("SELECT SUM(amount) FROM transactions WHERE type = 'R'")
    fun getTotalReceived(): Flow<Double?>

    @Query("SELECT SUM(amount) FROM transactions WHERE type = 'S'")
    fun getTotalSent(): Flow<Double?>

    @Query("SELECT balance FROM transactions ORDER BY date DESC, time DESC LIMIT 1")
    fun getBalance(): Flow<Double?>

    @Query("SELECT * FROM transactions WHERE date Between :startDate AND :endDate")
    fun getExpensesBetween(startDate: Long, endDate: Long): LiveData<List<Transaction>>

}