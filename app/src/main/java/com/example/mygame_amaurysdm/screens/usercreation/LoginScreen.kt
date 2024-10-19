package com.example.mygame_amaurysdm.screens.usercreation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mygame_amaurysdm.R
import com.example.mygame_amaurysdm.viewmodel.LoginData


@Preview(showBackground = true, device = "id:pixel_8a")
@Composable
fun LoginScreen(
    loginData: LoginData = LoginData("email@example.com", "******"),
    onLoginChange: (LoginData) -> Unit = {},
    onCreateAccountClick: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))

        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = stringResource(id = R.string.join_the_community_label),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = loginData.email,
            onValueChange = { onLoginChange(loginData.copy(email = it)) },
            label = { Text(text = "EMAIL") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)

        )

        OutlinedTextField(
            value = loginData.password,
            onValueChange = { onLoginChange(loginData.copy(password = it)) },
            label = { Text(text = "PASSWORD (8+ characters)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp)
        )

        Button(
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(
                text = "Login", fontWeight = FontWeight.Bold, fontSize = 15.sp
            )
        }

        Row() {
            Text(
                text = "Don't have an account?",
                fontWeight = FontWeight.Thin,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Create One",
                fontWeight = FontWeight.Thin,
                modifier = Modifier
                    .clickable { onCreateAccountClick() }
                    .padding(start = 5.dp),
                color = MaterialTheme.colorScheme.primary, textDecoration = TextDecoration.Underline
            )
        }
    }
}