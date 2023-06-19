package com.example.tp_project.data.note

import com.example.tp_project.data.note.NoteModel
import com.example.tp_project.domain.Note

class GetNotesConverter {

	fun convert(from: NoteModel): Note =
		Note(
			id = from.id,
			title = from.title,
			text = from.text
		)
}