package com.example.20230215-EsosaseheIgiehon-nycSchools.ui.screens.details


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.20230215-EsosaseheIgiehon-nycSchools.R
import com.example.20230215-EsosaseheIgiehon-nycSchools.model.NYCDetailResponseModelItem
import com.example.20230215-EsosaseheIgiehon-nycSchools.ui.screens.common.MainViewModel

@Composable
fun Details(
    schoolId: String = "",
    viewModel: MainViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit
) {
    viewModel.getNYCSchoolDetails(schoolId)
    Log.e("schoolId", "schoolId" + schoolId)

    val schoolDetails by remember { viewModel.schoolDetailsApiData }

    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colors.background,
            ) {
                Row {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            }
        }

    ) { padding ->
        for (schoolDetail in schoolDetails) {
            DetailsView(schoolDetail)
        }
    }
}

@Composable
fun DetailsView(nycDetailResponseModelItem: NYCDetailResponseModelItem) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.bg))
    ) {

        // Basic details
        item {
            nycDetailResponseModelItem.apply {

                val dogImage: Painter = painterResource(id = R.drawable.ic_launcher_foreground)
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(346.dp),
                    painter = dogImage,
                    alignment = Alignment.CenterStart,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }

        // My school details
        item {
            nycDetailResponseModelItem.apply {

                Spacer(modifier = Modifier.height(24.dp))
                Title(title = "School Name")
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = schoolName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 16.dp, 0.dp),
                    color = MaterialTheme.colors.surface,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Start
                )
            }
        }

        // Quick info
        item {
            nycDetailResponseModelItem.apply {

                Spacer(modifier = Modifier.height(24.dp))
                Title(title = "Score info")
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 16.dp, 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    InfoCard(
                        title = "ReadingAvgScore",
                        value = nycDetailResponseModelItem.satCriticalReadingAvgScore
                    )
                    InfoCard(
                        title = "MathAvgScore",
                        value = nycDetailResponseModelItem.satMathAvgScore
                    )
                    InfoCard(
                        title = "WritingAvgScore",
                        value = nycDetailResponseModelItem.satWritingAvgScore
                    )
                }
            }
        }
    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 0.dp, 0.dp),
        color = colorResource(id = R.color.text),
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start
    )
}
