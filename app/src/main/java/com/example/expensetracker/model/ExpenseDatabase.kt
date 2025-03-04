package com.example.expensetracker.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Expense::class], version = 1)
abstract class ExpenseDatabase: RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao

    companion object{
        @Volatile
        private var INSTANCE: ExpenseDatabase? = null

        fun getDatabase(context: Context): ExpenseDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExpenseDatabase::class.java,
                    "expense_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}