package com.bharat.slimi.feature_auth.presentation.register.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bharat.slimi.feature_auth.presentation.register.RegisterViewModel

@Composable
fun GenderStep(
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel
) {

    Column(
        modifier = modifier.background(Color.Yellow),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Gender Step")

        Button(
            onClick = {viewModel.goToNextStep()}
        ) {
            Text("Next")
        }




    }

}