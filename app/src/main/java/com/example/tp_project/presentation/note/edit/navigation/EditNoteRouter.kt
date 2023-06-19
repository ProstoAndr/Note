package com.example.tp_project.presentation.note.edit.navigation

import com.example.tp_project.presentation.note.list.navigation.ListNoteDestination
import com.github.terrakok.cicerone.Router

class EditNoteRouter(private val router: Router) {

	fun back() {
		router.backTo(ListNoteDestination)
	}
}