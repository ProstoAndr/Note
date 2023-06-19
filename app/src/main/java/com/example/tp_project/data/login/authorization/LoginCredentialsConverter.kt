package com.example.tp_project.data.login.authorization

import com.example.tp_project.domain.login.authorization.LoginCredentials

class LoginCredentialsConverter {

	fun convert(from: LoginCredentials): LoginCredentialsModel = LoginCredentialsModel(from.login, from.password)

}