package com.example.tp_project.domain.login.registration

import com.example.tp_project.domain.ErrorType

interface RegistrationRepository {

	suspend fun register(registrationCredentials: RegistrationCredentials): ErrorType
}