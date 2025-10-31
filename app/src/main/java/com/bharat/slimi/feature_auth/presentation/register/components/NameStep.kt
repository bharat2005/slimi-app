package com.bharat.slimi.feature_auth.presentation.register.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import com.bharat.slimi.feature_auth.presentation.register.RegisterViewModel

@Composable
fun NameStep(
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel
) {
    Column(
        modifier = modifier.background(Color.Green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Name Step")

        Button(
            onClick = {viewModel.goToNextStep()}
        ) {
            Text("Next")
        }

    }

}