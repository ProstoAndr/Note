package com.example.tp_project.data.note.create

import com.example.tp_project.data.note.NoteModel

class CreateNoteDataSourceImpl(private val createNoteApi: CreateNoteApi) : CreateNoteDataSource {

	override suspend fun create(note: NoteModel) {
		createNoteApi.create(note)
	}
}