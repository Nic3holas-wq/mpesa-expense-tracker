package com.example.expensetracker.view

import com.example.expensetracker.R
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.expensetracker.viewmodel.TransactionViewModel

//@Preview
@Composable
fun Transactions(viewModel: TransactionViewModel, navController: NavController){
    val transactions = viewModel.allTransactions.collectAsState(initial = emptyList()).value
    val totalSent by viewModel.totalSent.collectAsState(initial = 0.0)
    val displaySent = totalSent ?: 0.0
    val totalReceived by viewModel.totalReceived.collectAsState(initial = 0.0)
    val displayReceived = totalReceived ?: 0.0
    val totalBalance by viewModel.totalBalance.collectAsState(initial = 0.0)
    val displayBalance = totalBalance ?: 0.0
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0f, 0f, 0f, 0.9f))
            .padding(top = 25.dp),
    ) {

        TopNavigation("Transactions", navController)

        Column(

        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .padding(top = 25.dp, bottom = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .size(height = 80.dp, width = 130.dp),
                        colors = CardDefaults.cardColors(Color(0.22f, 0.21f, 0.21f, 0.85f)),

                        ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_arrow_downward_24),
                                    contentDescription = "Received money",
                                    tint = Color.Green,
                                    modifier = Modifier.size(50.dp)
                                )
                                Text(
                                    text = "Cash in",
                                    color = Color.White,
                                    fontSize = 16.sp
                                )
                            }

                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Ksh ${displayReceived}",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .size(height = 80.dp, width = 130.dp),
                        colors = CardDefaults.cardColors(Color(0.22f, 0.21f, 0.21f, 0.85f)),

                        ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_arrow_upward_24),
                                    contentDescription = "Sent money",
                                    tint = Color.Red,
                                    modifier = Modifier.size(50.dp)
                                )
                                Text(
                                    text = "Cash out",
                                    color = Color.White,
                                    fontSize = 16.sp
                                )
                            }

                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Ksh ${displaySent}",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

            }
            HorizontalDivider(thickness = 0.2.dp, color = Color(1f, 1f, 1f, 0.2f))

            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = "Overview",
                    color = Color.White,
                    fontSize = 20.sp
                )

                LazyColumn {
                    items(transactions){transaction ->
                        val statusColor = if (transaction.type == "R") Color.Green else Color.Red
                        Box(
                            contentAlignment = Alignment.Center
                        ){
                            Card(
                                modifier = Modifier
                                    .size(width = 370.dp, height = 120.dp)
                                    .padding(bottom = 5.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0.28f, 0.23f, 0.23f, 0.72f)
                                ),
                                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                            ) {
                                Row(
                                    modifier = Modifier.padding(5.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .background(statusColor, shape = CircleShape),
                                        contentAlignment = Alignment.Center
                                    ){
                                        Text(
                                            text = transaction.type,
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                    }
                                    Column(
                                        modifier = Modifier
                                            .padding(horizontal = 7.dp)
                                    ) {
                                        Text(
                                            text = transaction.message,
                                            color = Color.White,
                                            maxLines = 4,
                                            overflow = TextOverflow.Ellipsis,
                                            fontSize = 14.sp
                                        )
                                        Row(
                                        ) {
                                            Text(text = transaction.date, fontSize = 12.sp, color = Color(1f,1f,1f,0.4f))
                                            Spacer(modifier = Modifier.width(20.dp))
                                            Text(text = transaction.time,fontSize = 12.sp, color = Color(1f,1f,1f,0.4f))
                                        }
                                    }

                                }

                            }
                        }

                    }
                }

            }





            }

        }
    }
