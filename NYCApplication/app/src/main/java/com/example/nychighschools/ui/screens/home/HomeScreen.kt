package com.example.20230215-EsosaseheIgiehon-nycSchools.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.20230215-EsosaseheIgiehon-nycSchools.ui.screens.common.MainViewModel

@Composable
private fun ScreenContent(
    selectedUser: (String) -> Unit,
    viewModel: MainViewModel = hiltViewModel(),
) {

    Column(
        Modifier.fillMaxSize()
    ) {

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            NYCSchoolsList(viewModel, selectedUser)
        }

        Spacer(modifier = Modifier.navigationBarsPadding())
    }
}