package com.example.jetpackcompose.views

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcompose.R
import com.example.jetpackcompose.viewmodels.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val viewModel: LoginViewModel = viewModel()
    val username by viewModel.username.collectAsState()
    val isLoggedIn by viewModel.isLoggedIn.collectAsState()

    val context = LocalContext.current

    // Mostrar el Toast cuando el usuario inicia sesión correctamente
    LaunchedEffect(isLoggedIn) {
        if (isLoggedIn) {
            val sharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
            val token = sharedPreferences.getString("TOKEN", null)
            token?.let {
                Toast.makeText(context, "Bienvenido $username. Token: $it", Toast.LENGTH_LONG).show()
            }
        }
    }

    Scaffold(
        topBar = {
            WoofTopAppBar()
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            // Aquí puedes agregar tus elementos para la lista de perros
        }
    }
}

@Composable
fun TaskItem(
    //task: Task,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            Spacer(modifier = Modifier.width(50.dp))
           // TaskInformation(task.id, task.name, task.createdDate)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(88.dp)
                        .padding(8.dp),
                    painter = painterResource(R.drawable.ic_app),
                    contentDescription = null
                )
                Text(
                    text = "Life List - Tasks"
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun TaskInformation(
    taskId: Int,
    @StringRes taskName: Int,
    @StringRes createdDate: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.tasksd, taskId),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
        )
        Text(
            text = stringResource(taskName),
            style = MaterialTheme.typography.bodyLarge
        )
        Row(
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small)),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = stringResource(createdDate),
                style = MaterialTheme.typography.displayMedium
            )
            Spacer(modifier = Modifier.width(50.dp))

            Button(
                onClick = {}

            ){
                Text(text = "Done")
            }
        }
    }
}