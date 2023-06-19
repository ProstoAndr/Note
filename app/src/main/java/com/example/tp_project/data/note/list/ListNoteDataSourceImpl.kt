package com.example.tp_project.data.note.list

import com.example.tp_project.data.note.NoteModel

class ListNoteDataSourceImpl(private val service: ListNoteApi) : ListNoteDataSource {

	override suspend fun get(): List<NoteModel> =
		service.get()
}