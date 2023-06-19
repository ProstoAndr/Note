package com.example.tp_project.domain.note.edit

class DeleteNoteUseCase(private val noteRepository: NoteRepository) {

	suspend operator fun invoke(id: Int) {
		noteRepository.delete(id)
	}
}