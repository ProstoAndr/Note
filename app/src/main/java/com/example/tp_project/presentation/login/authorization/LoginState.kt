package com.example.tp_project.presentation.login.authorization

import com.example.tp_project.presentation.login.ValidationResult

data class LoginState(
	val emailResult: ValidationResult,
	val passwordResult: ValidationResult,
	val authorizing: Boolean = false
)
