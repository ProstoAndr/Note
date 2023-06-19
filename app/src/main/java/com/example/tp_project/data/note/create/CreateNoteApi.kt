package com.example.tp_project.data.note.create

import com.example.tp_project.data.note.NoteModel
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateNoteApi {

	@POST("/api/note")
	suspend fun create(@Body note: NoteModel)
}