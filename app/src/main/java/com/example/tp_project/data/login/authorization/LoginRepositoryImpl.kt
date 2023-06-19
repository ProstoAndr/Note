package com.example.tp_project.data.login.authorization

import com.example.tp_project.data.token.TokenDataSource
import com.example.tp_project.data.token.TokenModelConverter
import com.example.tp_project.domain.ErrorType
import com.example.tp_project.domain.login.authorization.LoginCredentials
import com.example.tp_project.domain.login.authorization.LoginRepository

class LoginRepositoryImpl(
	private val loginDataSource: LoginDataSource,
	private val tokenDataSource: TokenDataSource
) : LoginRepository {

	private val loginConverter = LoginCredentialsConverter()

	private val tokenModelConverter = TokenModelConverter()

	override suspend fun authentication(loginCredentials: LoginCredentials): ErrorType {

		val loginCredentialsModel = loginConverter.convert(loginCredentials)
		val resultToken = loginDataSource.authentication(loginCredentialsModel)

		if (resultToken.errorType.isNullOrEmpty()) {
			tokenDataSource.edit(resultToken)
		}

		return tokenModelConverter.convert(resultToken)
	}
}