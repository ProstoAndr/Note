package com.example.tp_project.domain.note.edit

import com.example.tp_project.domain.Note

class EditNoteUseCase(private val noteRepository: NoteRepository) {

	suspend operator fun invoke(note: Note) {
		noteRepository.edit(note)
	}
}