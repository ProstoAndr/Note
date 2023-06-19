package com.example.tp_project.data.login.authorization

import com.example.tp_project.data.token.TokenModel

class LoginDataSourceImpl(private val service: LoginApi) : LoginDataSource {

	override suspend fun authentication(loginCredentials: LoginCredentialsModel): TokenModel {
		return service.authentication(loginCredentials)
	}
}