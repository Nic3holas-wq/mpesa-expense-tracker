package com.example.expensetracker.view

import android.provider.CalendarContract
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.expensetracker.viewmodel.TransactionViewModel

@Composable
fun DailyReports(viewModel: TransactionViewModel, navController: NavController){
    val selectedPeriod = remember { mutableStateOf("daily") }
    val expenses = viewModel.getReport(selectedPeriod.value).observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0f, 0f, 0f, 0.9f))
            .padding(top = 30.dp)
    ) {
        TopNavigation("Daily Reports", navController)

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier
                .size(height = 150.dp, width = 370.dp)
                .padding(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black)
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
                        Text(text = "17", fontSize = 18.sp, fontWeight = FontWeight.Normal, color = Color.Green)
                        Text(text = "Ksh 9000", fontSize = 18.sp, fontWeight = FontWeight.Normal, color = Color.Green)
                        Text(text = "Ksh 1,000", fontSize = 18.sp, fontWeight = FontWeight.Normal, color = Color.Green)
                        Text(text = "Ksh 12,000", fontSize = 18.sp, fontWeight = FontWeight.Normal, color = Color.Green)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Card(
            modifier = Modifier
                .size(height = 170.dp, width = 370.dp)
                .padding(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            )
            {
                Text(text = "Yesterday's Expenses", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color.White)

                Row(
                    modifier = Modifier
                        .padding(5.dp),

                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    Column(

                    ) {
                        Text(text = "Amount Sent:", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                        Text(text = "Amount Received:", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                    }
                    Column(

                    ) {
                        Text(text = "Ksh 12,000", fontSize = 18.sp, fontWeight = FontWeight.Normal, color = Color.Green)
                        Text(text = "Ksh 2,000", fontSize = 18.sp, fontWeight = FontWeight.Normal, color = Color.Green)
                    }
                }

                Card(
                    modifier = Modifier
                        .size(height = 30.dp, width = 320.dp)
                        .padding(start = 15.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(1f,0f,0f,0.5f)),
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = "Yesterday you spent MORE than today.",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Card(
            modifier = Modifier
                .size(height = 170.dp, width = 370.dp)
                .padding(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            )
            {
                Text(text = "Today's Spending Habits", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color.White)

                Row(
                    modifier = Modifier
                        .padding(start = 20.dp, top = 15.dp),

                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    Column(

                    ) {
                        Text(text = "Morning:", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                        Text(text = "Afternoon:", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                        Text(text = "Evening:", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                    }
                    Column(

                    ) {
                        Text(text = "Ksh 4,000", fontSize = 18.sp, fontWeight = FontWeight.Normal, color = Color.Green)
                        Text(text = "Ksh 500", fontSize = 18.sp, fontWeight = FontWeight.Normal, color = Color.Green)
                        Text(text = "Ksh 4,500", fontSize = 18.sp, fontWeight = FontWeight.Normal, color = Color.Green)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Card(
            modifier = Modifier
                .size(height = 120.dp, width = 370.dp)
                .padding(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black)
        ) {
            Column(
                modifier = Modifier.padding(start = 20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            )
            {
                Text(text = "Today's Spending Habits", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                Text(text = "You spent 40% more than usual on transport. Consider using public transport or carpooling!", fontSize = 16.sp, fontWeight = FontWeight.Normal, color = Color.Green)
            }
        }

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