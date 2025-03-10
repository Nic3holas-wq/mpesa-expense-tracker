package com.example.expensetracker

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.model.TransactionDatabase
import com.example.expensetracker.model.repository.TransactionRepository
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme
import com.example.expensetracker.view.Home
import com.example.expensetracker.view.Transactions
import com.example.expensetracker.viewmodel.TransactionViewModel
import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.util.Log
import com.example.expensetracker.view.DailyReports
import com.example.expensetracker.view.MonthlyReports
import com.example.expensetracker.view.WeeklyReports
import com.example.expensetracker.view.YearlyReports
import com.example.expensetracker.viewmodel.TransactionViewModelFactory


class MainActivity : ComponentActivity() {
    override fun onStart() {
        super.onStart()
        requestBatteryOptimizationPermission(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repositoryTransaction = TransactionRepository(TransactionDatabase.getDatabase(this).transactionDao())

        val viewModelTransaction: TransactionViewModel = ViewModelProvider(
            this,
            TransactionViewModelFactory(application, repositoryTransaction) // Use the correct factory
        )[TransactionViewModel::class.java]

        val serviceIntent = Intent(this, ForegroundSmsService::class.java)
        startForegroundService(serviceIntent)

        enableEdgeToEdge()
        setContent {
            ExpenseTrackerTheme {
                val navController = rememberNavController()
                RequestSmsPermission(this)
                NavHost(navController, startDestination = "home") {
                    composable("home"){
                        Home(viewModelTransaction,navController)
                    }
                    composable("transactions"){
                        Transactions(viewModelTransaction,navController)
                    }
                    composable("daily_reports"){
                        DailyReports(viewModelTransaction, navController)
                    }
                    composable("weekly_reports"){
                        WeeklyReports(viewModelTransaction, navController)
                    }
                    composable("monthly_reports"){
                        MonthlyReports(viewModelTransaction, navController)
                    }
                    composable("yearly_reports"){
                        YearlyReports(viewModelTransaction, navController)
                    }
                }
            }
        }
    }

    fun requestBatteryOptimizationPermission(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val intent = Intent()
            val packageName = context.packageName
            val pm = context.getSystemService(Context.POWER_SERVICE) as android.os.PowerManager

            if (!pm.isIgnoringBatteryOptimizations(packageName)) {
                intent.action = Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
                intent.data = Uri.parse("package:$packageName")
                try {
                    context.startActivity(intent)
                } catch (e: Exception) {
                    Log.e("BatteryOptimization", "Error opening battery settings: ${e.message}")
                }
            }
        }
    }
}


@Composable
fun RequestSmsPermission(context: Context){
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = {granted ->
            if (granted){
                Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Permission Denied!", Toast.LENGTH_SHORT).show()
            }
        }
    )
    LaunchedEffect(Unit) {
        permissionLauncher.launch(Manifest.permission.RECEIVE_SMS)
    }
}
