package com.example.mygame_amaurysdm.screens.usercreation.Registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mygame_amaurysdm.viewmodel.Registration.EmailCreationViewModel
import com.example.mygame_amaurysdm.viewmodel.Registration.RegisterData


@Composable
fun EmailCreationScreen(
    registrationData: RegisterData,
    onRegistrationChange: (RegisterData) -> Unit = {},
    accountStep: MutableIntState,
    navController: NavHostController,
    emailCreationViewModel: EmailCreationViewModel = viewModel()
) {

    OutlinedTextField(
        value = registrationData.email,
        onValueChange = { onRegistrationChange(registrationData.copy(email = it)) },
        label = { Text(text = "EMAIL") }, leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email Icon", tint = MaterialTheme.colorScheme.primary
            )
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    )

    OutlinedTextField(
        value = registrationData.password,
        onValueChange = { onRegistrationChange(registrationData.copy(password = it)) },
        label = { Text(text = "PASSWORD (8+ characters)") }, leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Password Icon", tint = MaterialTheme.colorScheme.primary
            )
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp)
    )

    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Button(
            onClick = {
                emailCreationViewModel.onBackButtonClick(navController)
            },
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(
                text = "Back", fontWeight = FontWeight.Bold, fontSize = 15.sp
            )
        }

        Button(
            onClick = {
                if (emailCreationViewModel.checkEmailPassword(registrationData.email, registrationData.password)) {
                    accountStep.intValue++
                }
            },
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(
                text = "Next", fontWeight = FontWeight.Bold, fontSize = 15.sp
            )
        }
    }
}