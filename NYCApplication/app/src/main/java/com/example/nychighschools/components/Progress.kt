package com.example.20230215-EsosaseheIgiehon-nycSchools.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * @param isLoadingData if true circular progress bar will show.
 * Same composable used in all screens.
 */
@Composable
fun ShowProgressIndicator(
    isLoadingData: Boolean
) {
    if (isLoadingData ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}