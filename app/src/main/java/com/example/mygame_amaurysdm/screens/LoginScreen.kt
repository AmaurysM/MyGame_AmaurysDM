package com.example.mygame_amaurysdm.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AppTheme
import com.example.mygame_amaurysdm.R
import com.example.mygame_amaurysdm.model.LoginData
import kotlin.math.log


@Preview(showBackground = true, device = "id:pixel_8a")
@Composable
fun LoginScreen(
    loginData: LoginData = LoginData("email@example.com", "******")
    , onLoginChange: (LoginData) -> Unit = {}
    , onCreateAccountClick: () -> Unit = {}
    , onLoginClick: () -> Unit = {}
){
    AppTheme {
        var email by remember { mutableStateOf(loginData.email) }
        var password by remember { mutableStateOf(loginData.password) }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(id = R.string.join_the_community_label), style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = loginData.email,
                onValueChange = {onLoginChange(loginData.copy(email = it))},
                label = { Text(text = "EMAIL") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = loginData.password,
                onValueChange = { onLoginChange(loginData.copy(password = it ))},
                label = { Text(text = "PASSWORD (8+ characters)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = onCreateAccountClick
                , modifier = Modifier.fillMaxWidth()
                , shape = RoundedCornerShape(5.dp)
            ){
                Text(text = "Create Account"
                    , fontWeight = FontWeight.Bold
                    , fontSize = 15.sp
                )
            }

            Row(){
                Text(text = "Already have an account?"
                , fontWeight = FontWeight.Thin)
                Text(
                    text = "Login"
                    , fontWeight = FontWeight.Thin
                    , modifier = Modifier.clickable { onLoginClick() }
                )
            }
        }
    }
}