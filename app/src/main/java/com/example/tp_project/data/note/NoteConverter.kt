package com.example.tp_project.data.note

import com.example.tp_project.domain.Note

class NoteConverter {

	fun convert(from: Note): NoteModel =
		NoteModel(
			id = from.id,
			title = from.title,
			text = from.text
		)
}