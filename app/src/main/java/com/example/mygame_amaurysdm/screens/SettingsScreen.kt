package com.example.mygame_amaurysdm.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.model.UserBag

@Preview(showBackground = true)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()
) {
    val currentUser = UserBag.getCurrentUser()
    Column(modifier = modifier.background(MaterialTheme.colorScheme.background)) {
        val style = MaterialTheme.typography.titleLarge
        val color = MaterialTheme.colorScheme.inversePrimary
        Text(
            text = "Username: ${currentUser?.username}", style = style, color = color
        )
        Text(
            text = "Email: ${currentUser?.email}", style = style, color = color
        )
        Text(
            text = "Password: ${currentUser?.password}", style = style, color = color
        )
    }
}