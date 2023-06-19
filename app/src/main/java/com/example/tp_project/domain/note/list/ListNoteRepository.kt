package com.example.tp_project.domain.note.list

import com.example.tp_project.domain.Note

interface ListNoteRepository {

	suspend fun get(): List<Note>
}