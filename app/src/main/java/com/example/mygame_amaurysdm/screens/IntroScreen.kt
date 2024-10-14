package com.example.mygame_amaurysdm.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun IntroScreen(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(10.dp)
        .background(MaterialTheme.colorScheme.background)
    ) {
        Text(text = "Are you ready to be tested"
            , style = MaterialTheme.typography.titleLarge
            , modifier = Modifier.padding(bottom = 10.dp)
            , color = MaterialTheme.colorScheme.primary
        )

        Text(text = "The game is simple answer the questions correctly"
            , style = MaterialTheme.typography.labelLarge
            , color = MaterialTheme.colorScheme.primary
        )

        Row(modifier = Modifier.fillMaxSize()
            , horizontalArrangement = Arrangement.End
            , verticalAlignment = androidx.compose.ui.Alignment.Bottom
        ) {
            Button(onClick = { navController.navigate("game_Screen") }
                , shape = MaterialTheme.shapes.small) {
                Text(text ="Ready")
            }
        }
    }
}


/*@Composable
fun IntroScreen( navController: NavHostController = rememberNavController()){
    Text(text = "Are you ready to be tested"
        , style = MaterialTheme.typography.titleLarge
        , modifier = Modifier.padding(bottom = 10.dp)
        , color = MaterialTheme.colorScheme.primary
    )

    Text(text = "The game is simple answer the questions correctly"
        , style = MaterialTheme.typography.labelLarge
        , color = MaterialTheme.colorScheme.primary
    )

    Row(modifier = Modifier.fillMaxSize()
        , horizontalArrangement = Arrangement.End
        , verticalAlignment = androidx.compose.ui.Alignment.Bottom
    ) {
        Button(onClick = {  }
            , shape = MaterialTheme.shapes.small) {
            Text(text ="Ready")
        }
    }
}*/
