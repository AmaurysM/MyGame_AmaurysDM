package com.example.mygame_amaurysdm.screens.usercreation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.navigation.UserCreationDestinations
import com.example.mygame_amaurysdm.viewmodel.RegisterData
import com.example.mygame_amaurysdm.viewmodel.checkEmailPassword

@Preview(showBackground = true, device = "id:pixel_8a")
@Composable
fun RegisterScreen(
    navController: NavHostController = rememberNavController(),
    onLoginClick: () -> Unit = {},
    userCreationState: @Composable () -> Unit = {}
    , accountStep: MutableIntState = remember { mutableIntStateOf(1) }
) {
     Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(100.dp))

        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Step ${accountStep.intValue} of 2",
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "Your Account",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        userCreationState()

        /*when (accountStep.intValue) {
            1 -> Step1(
                registrationData, onRegistrationChange, onBackButtonClick, accountStep
            )

            2 -> Step2(
                registrationData, onRegistrationChange, onCreateAccountClick, accountStep
            )
        }*/

        HorizontalDivider(modifier = Modifier.padding(vertical = 10.dp))

        Row() {
            Text(
                text = "Already have an account?",
                fontWeight = FontWeight.Thin,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Login",
                fontWeight = FontWeight.Thin,
                modifier = Modifier
                    .clickable { onLoginClick() }
                    .padding(start = 5.dp),
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.Underline
            )
        }

    }

}


@Composable
fun Step1(
    registrationData: RegisterData,
    onRegistrationChange: (RegisterData) -> Unit = {},
    onBackButtonClick: () -> Unit = {},
    accountStep: MutableIntState
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
                onBackButtonClick()
            },
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(
                text = "Back", fontWeight = FontWeight.Bold, fontSize = 15.sp
            )
        }

        Button(
            onClick = {
                if (checkEmailPassword(registrationData.email, registrationData.password)) {
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

@Composable
fun Step2(
    registrationData: RegisterData,
    onRegistrationChange: (RegisterData) -> Unit = {},
    onCreateAccountClick: () -> Unit,
    accountStep: MutableIntState
) {
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
            onClick = { onCreateAccountClick() },
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(
                text = "Next", fontWeight = FontWeight.Bold, fontSize = 15.sp
            )
        }
    }

}