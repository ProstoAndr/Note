package com.example.tp_project.data.login.registration

import com.example.tp_project.domain.ErrorType
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistrationApi {

	@POST("/api/signUp")
	suspend fun register(@Body registrationCredentials: RegistrationCredentialsModel): ErrorType
}