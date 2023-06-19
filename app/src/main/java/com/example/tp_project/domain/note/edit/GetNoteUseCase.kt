package com.example.tp_project.domain.note.edit

class GetNoteUseCase(private val noteRepository: NoteRepository) {

	suspend operator fun invoke(id: Int) =
		noteRepository.get(id)
}