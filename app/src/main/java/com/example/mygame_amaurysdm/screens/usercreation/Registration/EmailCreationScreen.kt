package com.example.mygame_amaurysdm.screens.usercreation.Registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.viewmodel.Registration.EmailCreationViewModel
import com.example.mygame_amaurysdm.viewmodel.Registration.RegisterData

@Preview(showBackground = true)
@Composable
fun EmailCreationScreen(
    registrationData: RegisterData = RegisterData("", "", "", "", "", ""),
    onRegistrationChange: (RegisterData) -> Unit = {},
    accountStep: MutableIntState = mutableIntStateOf(0),
    navController: NavHostController = rememberNavController(),
    emailCreationViewModel: EmailCreationViewModel = viewModel()
) {
    Column() {
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
                    if (emailCreationViewModel.checkEmailPassword(
                            registrationData.email,
                            registrationData.password
                        )
                    ) {
                        accountStep.intValue++
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