package com.example.tp_project.domain.note.edit

import com.example.tp_project.domain.Note

interface NoteRepository {

	suspend fun get(id: Int): Note

	suspend fun delete(id: Int)

	suspend fun edit(note: Note)
}