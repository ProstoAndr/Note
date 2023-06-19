package com.example.tp_project.data.note.create

import com.example.tp_project.data.note.NoteConverter
import com.example.tp_project.domain.Note
import com.example.tp_project.domain.note.create.CreateNoteRepository

class CreateNoteRepositoryImpl(
	private val createNoteDataSource: CreateNoteDataSource,
	private val converter: NoteConverter
) : CreateNoteRepository {

	override suspend fun create(note: Note) {
		createNoteDataSource.create(converter.convert(note))
	}
}