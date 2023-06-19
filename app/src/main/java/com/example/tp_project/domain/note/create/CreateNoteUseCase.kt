package com.example.tp_project.domain.note.create

import com.example.tp_project.domain.Note

class CreateNoteUseCase(private val createNoteRepository: CreateNoteRepository) {

	suspend operator fun invoke(note: Note) {
		createNoteRepository.create(note)
	}
}