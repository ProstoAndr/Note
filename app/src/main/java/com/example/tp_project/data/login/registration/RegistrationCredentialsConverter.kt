package com.example.tp_project.data.login.registration

import com.example.tp_project.domain.login.registration.RegistrationCredentials

class RegistrationCredentialsConverter {

	fun convert(from: RegistrationCredentials): RegistrationCredentialsModel = RegistrationCredentialsModel(from.login, from.password)

}