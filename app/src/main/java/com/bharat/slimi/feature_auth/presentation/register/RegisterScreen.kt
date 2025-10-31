package com.bharat.slimi.feature_auth.presentation.register

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bharat.slimi.feature_auth.presentation.register.components.AuthStep
import com.bharat.slimi.feature_auth.presentation.register.components.DobStep
import com.bharat.slimi.feature_auth.presentation.register.components.GenderStep
import com.bharat.slimi.feature_auth.presentation.register.components.GoalStep
import com.bharat.slimi.feature_auth.presentation.register.components.HeightStep
import com.bharat.slimi.feature_auth.presentation.register.components.NameStep
import com.bharat.slimi.feature_auth.presentation.register.components.WeightStep

@Composable
fun RegisterScreen(
    viewModel : RegisterViewModel = viewModel(),
    onExit : () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    BackHandler {
        val currentStep = uiState.currentStep
        if(currentStep == RegistrationStep.GENDER_STEP){
            onExit()
        } else {
            viewModel.goToPreviousStep()
        }

    }


    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Progress Bar
            Box(
                modifier = Modifier.fillMaxWidth().height(50.dp).background(Color.Black)
            )

            //Registration Steps
            AnimatedContent(
                targetState = uiState.currentStep,
                transitionSpec = {
                    if(targetState.ordinal > initialState.ordinal){
                        slideInHorizontally(initialOffsetX = { it }) + fadeIn() togetherWith
                                slideOutHorizontally(targetOffsetX = { -it }) + fadeOut()
                    } else {
                        slideInHorizontally(initialOffsetX = { -it }) + fadeIn() togetherWith
                                slideOutHorizontally(targetOffsetX = { -it }) + fadeOut()
                    }

                }
            ) { targetState ->
                when(targetState){
                    RegistrationStep.GENDER_STEP -> GenderStep(modifier = Modifier.fillMaxSize(), viewModel = viewModel)
                    RegistrationStep.GOAL_STEP -> GoalStep(modifier = Modifier.fillMaxSize(), viewModel = viewModel)
                    RegistrationStep.NAME_STEP -> NameStep(modifier = Modifier.fillMaxSize(), viewModel = viewModel)
                    RegistrationStep.DOB_STEP -> DobStep(modifier = Modifier.fillMaxSize(), viewModel = viewModel)
                    RegistrationStep.HEIGHT_STEP -> HeightStep(modifier = Modifier.fillMaxSize(), viewModel = viewModel)
                    RegistrationStep.WEIGHT_STEP -> WeightStep(modifier = Modifier.fillMaxSize(), viewModel = viewModel)
                    RegistrationStep.AUTH_STEP -> AuthStep(modifier = Modifier.fillMaxSize(), viewModel = viewModel)
                }

            }
        }
    }

}