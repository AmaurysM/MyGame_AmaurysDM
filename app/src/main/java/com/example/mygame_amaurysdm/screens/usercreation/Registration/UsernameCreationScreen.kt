package com.example.mygame_amaurysdm.screens.usercreation.Registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import com.example.mygame_amaurysdm.viewmodel.Registration.RegisterData
import com.example.mygame_amaurysdm.viewmodel.Registration.UsernameCreationViewModel


@Composable
fun UsernameCreationScreen(
    registrationData: RegisterData,
    onRegistrationChange: (RegisterData) -> Unit = {},
    accountStep: MutableIntState,
    navController: NavHostController,
    usernameCreationViewModel: UsernameCreationViewModel = viewModel()
) {
    Column {
        OutlinedTextField(
            value = registrationData.username,
            onValueChange = { onRegistrationChange(registrationData.copy(username = it)) },
            label = { Text(text = "USERNAME") }, leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person Icon", tint = MaterialTheme.colorScheme.primary
                )
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)

        )

        OutlinedTextField(
            value = registrationData.firstName,
            onValueChange = { onRegistrationChange(registrationData.copy(firstName = it)) },
            label = { Text(text = "FIRST NAME") }, leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "First Name Icon", tint = MaterialTheme.colorScheme.primary
                )
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)

        )

        OutlinedTextField(
            value = registrationData.lastName,
            onValueChange = { onRegistrationChange(registrationData.copy(lastName = it)) },
            label = { Text(text = "LAST NAME") }, leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Last Name Icon", tint = MaterialTheme.colorScheme.primary
                )
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )

        OutlinedTextField(
            value = registrationData.dateOfBirth,
            onValueChange = { onRegistrationChange(registrationData.copy(dateOfBirth = it)) },
            label = { Text(text = "DATE OF BIRTH") }, leadingIcon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Date Icon", tint = MaterialTheme.colorScheme.primary
                )
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(
                onClick = { accountStep.intValue-- },
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = "Back", fontWeight = FontWeight.Bold, fontSize = 15.sp
                )
            }

            Button(
                onClick = {
                    if (usernameCreationViewModel.checkRegister(registrationData)) {
                        usernameCreationViewModel.onCreateAccountClick(navController)
                    }
                },
                colors = ButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = MaterialTheme.colorScheme.secondary,
                    disabledContentColor = MaterialTheme.colorScheme.onSecondary
                ),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = "Next", fontWeight = FontWeight.Bold, fontSize = 15.sp
                )
            }
        }
    }

}