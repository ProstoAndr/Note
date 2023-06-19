package com.example.tp_project.data.login.registration

import com.example.tp_project.domain.ErrorType

interface RegistrationDataSource {

	suspend fun register(registrationCredentialsModel: RegistrationCredentialsModel): ErrorType
}