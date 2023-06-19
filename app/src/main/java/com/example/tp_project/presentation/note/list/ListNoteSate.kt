package com.example.tp_project.presentation.note.list

import com.example.tp_project.domain.Note

sealed interface ListNoteSate {

	object Initial : ListNoteSate

	object Loading : ListNoteSate

	object Empty : ListNoteSate

	data class Content(
		val notes: List<Note> = listOf()
	) : ListNoteSate
}