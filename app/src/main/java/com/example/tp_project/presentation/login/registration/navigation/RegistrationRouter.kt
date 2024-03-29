package com.example.tp_project.presentation.login.registration.navigation

import com.example.tp_project.presentation.login.authorization.navigation.AuthorizationDestination
import com.example.tp_project.presentation.title.navigation.TitleDestination
import com.github.terrakok.cicerone.Router

class RegistrationRouter(private val router: Router) {

	fun openAuthorization() {
		router.navigateTo(AuthorizationDestination)
	}

	fun back() {
		router.backTo(TitleDestination)
	}
}