package com.example.tp_project.data.note.list

import com.example.tp_project.data.note.NoteModel
import retrofit2.http.GET

interface ListNoteApi {

	@GET("/api/notes")
	suspend fun get(): List<NoteModel>
}