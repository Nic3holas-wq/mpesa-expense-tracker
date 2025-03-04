package com.example.expensetracker.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch


//@Preview
@Composable
fun Home( navController: NavController){
    var savings by remember {
        mutableFloatStateOf(0.15f)
    }
    var sent by remember { mutableStateOf(2000) }
    var received by remember { mutableStateOf(10000) }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column(
                modifier = Modifier
                    .height(600.dp)
                    .width(250.dp)
                    .background(Color.Black)
                    .padding(16.dp)
                    .padding(top = 30.dp)
            ) {
                Text("Goals", fontSize = 18.sp ,color = Color.White, modifier = Modifier.padding(8.dp))
                Text("Savings", fontSize = 18.sp, color = Color.White, modifier = Modifier.padding(8.dp))
                Text("Alerts", fontSize = 18.sp, color = Color.White, modifier = Modifier.padding(8.dp))
                Text("Settings", fontSize = 18.sp, color = Color.White, modifier = Modifier.padding(8.dp))
                Text("Share app", fontSize = 18.sp, color = Color.White, modifier = Modifier.padding(8.dp))
            }
        }
    ) {
        Column(
            modifier = Modifier
                .background(Color(0f, 0f, 0f, 0.9f))
                .fillMaxSize()
                .padding(top = 25.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = { scope.launch{drawerState.open()}}
                ) {
                    Icon(
                        modifier = Modifier
                            .size(40.dp),
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Expenses",
                    fontSize = 24.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(110.dp))
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "Notifications",
                        modifier = Modifier.size(28.dp),
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "More Options",
                        modifier = Modifier.size(28.dp),
                        tint = Color.White
                    )
                }
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                color = Color(1f, 1f, 1f, 0.2f)
            )

            Row(
                modifier = Modifier
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        fontSize = 20.sp,
                        text = "Savings",
                        color = Color.White
                    )
                    Box(
                        contentAlignment = Alignment.Center,

                        modifier = Modifier.size(62.dp)
                    ){
                        CircularProgressIndicator(
                            modifier = Modifier.width(90.dp),
                            progress = savings,
                            color = Color.Black,
                            trackColor = Color.Green
                        )
                        Text(
                            modifier = Modifier.padding(top = 15.dp),
                            text = "${((1-savings) * 100).toInt()}%",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                    }

                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)

                ) {
                    Text(
                        text = "Sent",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = "Ksh${sent.toInt()}",
                        color = Color.Red,
                        fontSize = 20.sp
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Received",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = "Ksh${received.toInt()}",
                        color = Color.Green,
                        fontSize = 20.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            HorizontalDivider(thickness = 0.1.dp, color = Color(1f, 1f, 1f, 0.5f))

            Text(
                modifier = Modifier.padding(10.dp),
                text = "Transactions",
                color = Color.White,
                fontSize = 24.sp
            )



            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
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
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                TextButton(
                    onClick = {navController.navigate("transactions")},

                    ) {
                    Text(
                        text = "See more...",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
                HorizontalDivider(thickness = 0.3.dp, color = Color(1f, 1f, 1f, 0.5f))

                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Your Goals", color = Color.White, fontSize = 20.sp)

                Row (
                    modifier = Modifier.fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,

                            modifier = Modifier.size(62.dp)
                                .padding(bottom = 15.dp)
                        ){
                            CircularProgressIndicator(
                                modifier = Modifier.width(90.dp),
                                progress = savings,
                                color = Color.Black,
                                trackColor = Color.Green
                            )
                            Text(
                                modifier = Modifier.padding(top = 15.dp),
                                text = "${((1-savings) * 100).toInt()}%",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Car",
                            color = Color.White,
                            fontSize = 20.sp
                        )

                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,

                            modifier = Modifier.size(62.dp)
                                .padding(bottom = 15.dp)
                        ){
                            CircularProgressIndicator(
                                modifier = Modifier.width(90.dp),
                                progress = savings,
                                color = Color.Black,
                                trackColor = Color.Green
                            )
                            Text(
                                modifier = Modifier.padding(top = 15.dp),
                                text = "${((1-savings) * 100).toInt()}%",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Computer",
                            color = Color.White,
                            fontSize = 20.sp
                        )

                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,

                            modifier = Modifier.size(62.dp)
                                .padding(bottom = 15.dp)
                        ){
                            CircularProgressIndicator(
                                modifier = Modifier.width(90.dp),
                                progress = savings,
                                color = Color.Black,
                                trackColor = Color.Green
                            )
                            Text(
                                modifier = Modifier.padding(top = 15.dp),
                                text = "${((1-savings) * 100).toInt()}%",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "House",
                            color = Color.White,
                            fontSize = 20.sp
                        )

                    }

                }

                OutlinedButton(
                    onClick = {}
                ) {
                    Text(text = "Set new goal", color = Color.White)
                }

                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                ) {

                    Card(
                        modifier = Modifier
                            .size(height = 100.dp, width = 150.dp)
                            .padding(5.dp),

                        colors = CardDefaults.cardColors(Color(0.27f, 0.23f, 0.23f, 0.5f))
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = "Weekly Goals",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(48.dp)

                                )
                                Text(
                                    text = "Weekly Goals",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                        }

                    }

                    Card(
                        modifier = Modifier
                            .size(height = 100.dp, width = 150.dp)
                            .padding(5.dp),

                        colors = CardDefaults.cardColors(Color(0.27f, 0.23f, 0.23f, 0.5f))
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = "Weekly Goals",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(48.dp)

                                )
                                Text(
                                    text = "Monthly Goals",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                        }

                    }
                }
            }
        }
    }
    }


