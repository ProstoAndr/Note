package com.example.tp_project.domain.note.list

import com.example.tp_project.domain.Note

class GetNotesUseCase(private val listNoteRepository: ListNoteRepository) {

	suspend operator fun invoke(): List<Note> =
		listNoteRepository.get()
}