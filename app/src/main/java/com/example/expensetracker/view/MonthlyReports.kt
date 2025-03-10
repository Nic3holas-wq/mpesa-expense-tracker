package com.example.expensetracker.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.expensetracker.viewmodel.TransactionViewModel

@Composable
fun MonthlyReports(viewModel: TransactionViewModel, navController: NavController){
    val selectedPeriod = remember { mutableStateOf("monthly") }
    val expenses = viewModel.getReport(selectedPeriod.value).observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0f, 0f, 0f, 0.9f))
            .padding(top = 30.dp)
    ) {
        TopNavigation("Monthly Reports", navController)
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "From: 07/03/2025 To: 14/03/2025",
                fontSize = 20.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .size(height = 150.dp, width = 370.dp)
                .padding(10.dp)

        ) {
            Column(
                horizontalAlignment = Alignment.Start
            )
            {
                Row(
                    modifier = Modifier
                        .padding(5.dp),

                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    Column(

                    ) {
                        Text(text = "Completed Transactions:", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                        Text(text = "Amount Sent:", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                        Text(text = "Amount Received:", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                        Text(text = "Account Balance:", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                    }
                    Column(

                    ) {
                        Text(text = "35", fontSize = 18.sp, fontWeight = FontWeight.Normal, color = Color.Green)
                        Text(text = "Ksh 100,000", fontSize = 18.sp, fontWeight = FontWeight.Normal, color = Color.Green)
                        Text(text = "Ksh 20,000", fontSize = 18.sp, fontWeight = FontWeight.Normal, color = Color.Green)
                        Text(text = "Ksh 40,000", fontSize = 18.sp, fontWeight = FontWeight.Normal, color = Color.Green)
                    }
                }
            }
        }

        Card(
            modifier = Modifier
                .size(width = 370.dp, height = 150.dp)
                .padding(5.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Highest amount spent in a day", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                Text(text = "Tuesday 04/03/2025: Ksh 70,000", fontSize = 16.sp, fontWeight = FontWeight.Normal, color = Color.Green)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Highest amount spent in a week", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                Text(text = "Week 4: Ksh 100,000", fontSize = 16.sp, fontWeight = FontWeight.Normal, color = Color.Green)
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedButton(
                onClick = {},
                border = BorderStroke(2.dp, Color.Green)
            ) {
                Text(text = "Print Report", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}