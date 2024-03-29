package com.example.tp_project.presentation.login.authorization.navigation

import com.example.tp_project.presentation.note.list.navigation.ListNoteDestination
import com.example.tp_project.presentation.login.registration.navigation.RegistrationDestination
import com.example.tp_project.presentation.title.navigation.TitleDestination
import com.github.terrakok.cicerone.Router

class AuthorizationRouter(private val router: Router) {

	fun openRegistration() {
		router.navigateTo(RegistrationDestination)
	}

	fun back() {
		router.backTo(TitleDestination)
	}

	fun openListNote() {
		router.newRootScreen(ListNoteDestination)
	}
}