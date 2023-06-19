package com.example.tp_project.data.note.create

import com.example.tp_project.data.note.NoteModel

interface CreateNoteDataSource {

	suspend fun create(note: NoteModel)
}