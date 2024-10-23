package com.example.mygame_amaurysdm.screens.usercreation.Registration

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mygame_amaurysdm.viewmodel.Registration.RegisterViewModel


@Composable
fun RegisterScreen(
    modifier: Modifier
    , navController: NavHostController
    , registerViewModel: RegisterViewModel = viewModel()
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
                text = "Step ${registerViewModel.accountStep.intValue} of 2",
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
         registerViewModel.screenState(navController)

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
                    .clickable { registerViewModel.onLoginClick(navController) }
                    .padding(start = 5.dp),
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.Underline
            )
        }

    }

}


