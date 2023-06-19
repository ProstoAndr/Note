package com.example.tp_project.data.note.list

import com.example.tp_project.data.note.GetNotesConverter
import com.example.tp_project.domain.Note
import com.example.tp_project.domain.note.list.ListNoteRepository

class ListNoteRepositoryImpl(
	private val listNoteDataSource: ListNoteDataSource,
	private val getNotesConverter: GetNotesConverter
): ListNoteRepository {

	override suspend fun get(): List<Note> =
		listNoteDataSource.get().map { item ->
			getNotesConverter.convert(item)
		}
}