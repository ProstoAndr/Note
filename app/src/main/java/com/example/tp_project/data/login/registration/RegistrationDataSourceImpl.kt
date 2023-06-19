package com.example.tp_project.data.login.registration

import com.example.tp_project.domain.ErrorType

class RegistrationDataSourceImpl(private val service: RegistrationApi) : RegistrationDataSource {

	override suspend fun register(registrationCredentialsModel: RegistrationCredentialsModel): ErrorType =
		service.register(registrationCredentialsModel)
}