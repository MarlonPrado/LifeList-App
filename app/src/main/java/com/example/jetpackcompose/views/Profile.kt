package com.example.jetpackcompose.views

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.jetpackcompose.R
import com.example.jetpackcompose.viewmodels.LoginViewModel
import com.example.jetpackcompose.navigation.MyAppRoute
import com.example.jetpackcompose.navigation.MyAppNavigationActions

@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val sharedPreferences = remember { context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE) }
    val userName = sharedPreferences.getString("USERNAME", "User") ?: "User"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_app),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Hola $userName!", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                val sharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
                with(sharedPreferences.edit()) {
                    remove("TOKEN")
                    remove("USERNAME")
                    apply()
                }
                navController.navigate(MyAppRoute.LOGIN) {
                    popUpTo(0) { inclusive = true }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "LOGOUT", color = Color.White)
        }
    }
}
