package com.bharat.slimi.feature_auth.presentation.register.components

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bharat.slimi.feature_auth.presentation.register.RegisterViewModel

@Composable
fun HeightStep(
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel
) {

    Column(
        modifier = modifier.background(Color.Magenta),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Height Step")

        Button(
            onClick = {viewModel.goToNextStep()}
        ) {
            Text("Next")
        }

    }

}