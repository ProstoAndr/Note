package com.example.tp_project.data.note.edit

import com.example.tp_project.data.note.GetNotesConverter
import com.example.tp_project.data.note.NoteConverter
import com.example.tp_project.domain.Note
import com.example.tp_project.domain.note.edit.NoteRepository

class NoteRepositoryImpl(
	private val noteDataSource: NoteDataSource,
	private val converterNote: NoteConverter,
	private val getNotesConverter: GetNotesConverter
): NoteRepository {

	override suspend fun get(id: Int): Note =
		getNotesConverter.convert(noteDataSource.get(id))

	override suspend fun delete(id: Int) {
		noteDataSource.delete(id)
	}

	override suspend fun edit(note: Note) {
		noteDataSource.edit(converterNote.convert(note))
	}
}