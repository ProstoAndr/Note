package com.example.tp_project.data.note.edit

import com.example.tp_project.data.note.NoteModel

interface NoteDataSource {

	suspend fun get(id: Int): NoteModel

	suspend fun delete(id: Int)

	suspend fun edit(note: NoteModel)
}