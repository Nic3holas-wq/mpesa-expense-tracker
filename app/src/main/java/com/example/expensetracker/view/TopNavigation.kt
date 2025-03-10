package com.example.expensetracker.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TopNavigation(page: String, navController: NavController){
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
            text = page,
            color = Color.White,
            fontSize = 24.sp
        )
    }
    HorizontalDivider(thickness = 0.2.dp, color = Color(1f, 1f, 1f, 0.2f))
}