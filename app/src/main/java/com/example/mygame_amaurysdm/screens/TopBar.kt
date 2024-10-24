package com.example.mygame_amaurysdm.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.R
import com.example.mygame_amaurysdm.model.UserBag
import com.example.mygame_amaurysdm.viewmodel.TopBarViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    topBarViewModel: TopBarViewModel = TopBarViewModel(),
    visible: Boolean = true

) {

    /*Scaffold(
        topBar = {*/
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                actions = {
                    Row(horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            topBarViewModel.userPicClicked(navController)
                        }
                    ) {
                        Text(
                            text = (UserBag.getCurrentUser().username ?: "*****").uppercase(),
                            modifier = Modifier.padding(end = 10.dp)
                        )
                        Icon(
                            imageVector = Icons.Outlined.AccountCircle,
                            contentDescription = "Account",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(end = 10.dp)
                        )
                    }
                },
                title = {
                    Text(text = stringResource(R.string.app_name), modifier = Modifier.clickable {
                        topBarViewModel.logoClicked(navController)
                    })
                }
            )
        /*}, content = { padding ->
            QuizNav(Modifier.padding(padding), navController)
        }
    )*/
}
