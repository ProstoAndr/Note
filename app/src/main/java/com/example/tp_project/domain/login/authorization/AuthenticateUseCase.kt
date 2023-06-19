package com.example.tp_project.domain.login.authorization

import com.example.tp_project.domain.ErrorType

class AuthenticateUseCase(private val loginRepository: LoginRepository) {

	suspend operator fun invoke(auth: LoginCredentials) : ErrorType =
		loginRepository.authentication(auth)
}