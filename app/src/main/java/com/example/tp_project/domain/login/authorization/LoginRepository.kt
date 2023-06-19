package com.example.tp_project.domain.login.authorization

import com.example.tp_project.domain.ErrorType

interface LoginRepository {

	suspend fun authentication(loginCredentials: LoginCredentials) : ErrorType
}