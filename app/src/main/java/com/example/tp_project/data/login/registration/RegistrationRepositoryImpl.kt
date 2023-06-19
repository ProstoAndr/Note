package com.example.tp_project.data.login.registration

import com.example.tp_project.domain.ErrorType
import com.example.tp_project.domain.login.registration.RegistrationCredentials
import com.example.tp_project.domain.login.registration.RegistrationRepository

class RegistrationRepositoryImpl(
	private val registrationConverter: RegistrationCredentialsConverter,
	private val registrationDataSource: RegistrationDataSource
) : RegistrationRepository {

	override suspend fun register(registrationCredentials: RegistrationCredentials): ErrorType =
		registrationDataSource.register(registrationConverter.convert(registrationCredentials))
}