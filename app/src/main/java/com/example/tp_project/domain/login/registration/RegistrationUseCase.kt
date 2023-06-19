package com.example.tp_project.domain.login.registration

import com.example.tp_project.domain.ErrorType

class RegistrationUseCase(private val registrationRepository: RegistrationRepository) {

	suspend operator fun invoke(registrationCredentials: RegistrationCredentials): ErrorType =
		registrationRepository.register(registrationCredentials)
}