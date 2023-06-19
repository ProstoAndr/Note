package com.example.tp_project.presentation.title.navigation

import com.example.tp_project.presentation.login.authorization.navigation.AuthorizationDestination
import com.example.tp_project.presentation.login.registration.navigation.RegistrationDestination
import com.github.terrakok.cicerone.Router

class TitleRouter(private val router: Router) {

	fun openAuthorization() {
		router.navigateTo(AuthorizationDestination)
	}

	fun openRegistration() {
		router.navigateTo(RegistrationDestination)
	}
}