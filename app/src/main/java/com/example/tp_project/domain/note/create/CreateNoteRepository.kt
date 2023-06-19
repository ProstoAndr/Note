package com.example.tp_project.domain.note.create

import com.example.tp_project.domain.Note

interface CreateNoteRepository {

	suspend fun create(note: Note)
}