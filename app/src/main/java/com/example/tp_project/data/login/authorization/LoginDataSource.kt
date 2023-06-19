package com.example.tp_project.data.login.authorization

import com.example.tp_project.data.token.TokenModel

interface LoginDataSource {

	suspend fun authentication(loginCredentials: LoginCredentialsModel): TokenModel
}