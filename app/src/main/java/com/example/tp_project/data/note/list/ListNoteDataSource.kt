package com.example.tp_project.data.note.list

import com.example.tp_project.data.note.NoteModel

interface ListNoteDataSource {

	suspend fun get(): List<NoteModel>
}