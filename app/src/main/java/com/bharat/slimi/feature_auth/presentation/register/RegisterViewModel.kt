package com.bharat.slimi.feature_auth.presentation.register

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

enum class RegistrationStep{
    GENDER_STEP,
    GOAL_STEP,
    NAME_STEP,
    DOB_STEP,
    HEIGHT_STEP,
    WEIGHT_STEP,
    AUTH_STEP
}

data class RegisterUiState(
    val currentStep : RegistrationStep = RegistrationStep.GENDER_STEP
)

class RegisterViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState = _uiState.asStateFlow()

    fun goToNextStep(){
        val nextStep = when(uiState.value.currentStep){
            RegistrationStep.GENDER_STEP -> RegistrationStep.GOAL_STEP
            RegistrationStep.GOAL_STEP -> RegistrationStep.NAME_STEP
            RegistrationStep.NAME_STEP -> RegistrationStep.DOB_STEP
            RegistrationStep.DOB_STEP -> RegistrationStep.HEIGHT_STEP
            RegistrationStep.HEIGHT_STEP -> RegistrationStep.WEIGHT_STEP
            RegistrationStep.WEIGHT_STEP -> RegistrationStep.AUTH_STEP
            RegistrationStep.AUTH_STEP -> null
        }
        if(nextStep != null){
            _uiState.update { it.copy(currentStep = nextStep) }
        }
    }



}