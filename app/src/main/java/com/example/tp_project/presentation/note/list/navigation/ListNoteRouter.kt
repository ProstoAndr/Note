package com.example.tp_project.presentation.note.list.navigation

import com.example.tp_project.presentation.note.create.navigation.CreateNoteDestination
import com.example.tp_project.presentation.note.edit.navigation.EditNoteDestination
import com.example.tp_project.presentation.title.navigation.TitleDestination
import com.github.terrakok.cicerone.Router

class ListNoteRouter(private val router: Router) {

	fun openEditNote(id: Int) {
		router.navigateTo(EditNoteDestination(id))
	}

	fun openNewNote() {
		router.navigateTo(CreateNoteDestination)
	}

	fun openTitle() {
		router.newRootScreen(TitleDestination)
	}
}