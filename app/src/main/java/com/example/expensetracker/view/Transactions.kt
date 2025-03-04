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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

//@Preview
@Composable
fun Transactions(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0f, 0f, 0f, 0.9f))
            .padding(top = 25.dp),
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ){

            IconButton(
                onClick = {navController.navigate("Home")}
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(35.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Transactions",
                color = Color.White,
                fontSize = 24.sp
            )
        }
        HorizontalDivider(thickness = 0.2.dp, color = Color(1f, 1f, 1f, 0.2f))

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
                        text = "Ksh 29,000",
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
                        text = "Ksh 40,450",
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

                Box(
                    modifier = Modifier
                        .padding(top = 15.dp),
                    contentAlignment = Alignment.Center
                ){
                    Card(
                        modifier = Modifier
                            .size(width = 370.dp, height = 60.dp),
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
                                    .background(Color.Green, shape = CircleShape),
                                contentAlignment = Alignment.Center
                            ){
                                Text(
                                    text = "R",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                            Column(
                                modifier = Modifier.padding(horizontal = 7.dp)
                            ) {
                                Text(
                                    text = "Confirmed you have received...",
                                    color = Color.White,
                                    fontSize = 16.sp
                                )
                                Row(
                                    modifier = Modifier.padding(top = 4.dp)
                                ) {
                                    Text(text = "02/03/2025", color = Color(1f,1f,1f,0.4f))
                                    Spacer(modifier = Modifier.width(20.dp))
                                    Text(text = "21:50", color = Color(1f,1f,1f,0.4f))
                                }
                            }

                        }

                    }
                }

                Box(
                    modifier = Modifier
                        .padding(vertical = 5.dp),
                    contentAlignment = Alignment.Center
                ){
                    Card(
                        modifier = Modifier
                            .size(width = 370.dp, height = 60.dp),
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
                                    .background(Color.Red, shape = CircleShape),
                                contentAlignment = Alignment.Center
                            ){
                                Text(
                                    text = "S",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                            Column(
                                modifier = Modifier.padding(horizontal = 7.dp)
                            ) {
                                Text(
                                    text = "Confirmed you have sent...",
                                    color = Color.White,
                                    fontSize = 16.sp
                                )
                                Row(
                                    modifier = Modifier.padding(top = 4.dp)
                                ) {
                                    Text(text = "04/03/2025", color = Color(1f,1f,1f,0.4f))
                                    Spacer(modifier = Modifier.width(20.dp))
                                    Text(text = "22:00", color = Color(1f,1f,1f,0.4f))
                                }
                            }

                        }

                    }
                }
            }

        }
    }
}