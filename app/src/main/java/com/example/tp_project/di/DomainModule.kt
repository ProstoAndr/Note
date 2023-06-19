package com.example.tp_project.di

import com.example.tp_project.domain.note.create.CreateNoteUseCase
import com.example.tp_project.domain.note.list.GetNotesUseCase
import com.example.tp_project.domain.login.authorization.AuthenticateUseCase
import com.example.tp_project.domain.login.registration.RegistrationUseCase
import com.example.tp_project.domain.note.edit.DeleteNoteUseCase
import com.example.tp_project.domain.note.edit.EditNoteUseCase
import com.example.tp_project.domain.note.edit.GetNoteUseCase
import org.koin.dsl.module

val domainModule = module {

	factory<AuthenticateUseCase> {
		AuthenticateUseCase(loginRepository = get())
	}

	factory<RegistrationUseCase> {
		RegistrationUseCase(registrationRepository = get())
	}

	factory<GetNotesUseCase> {
		GetNotesUseCase(listNoteRepository = get())
	}

	factory<CreateNoteUseCase> {
		CreateNoteUseCase(createNoteRepository = get())
	}

	factory<GetNoteUseCase> {
		GetNoteUseCase(noteRepository = get())
	}

	factory<DeleteNoteUseCase> {
		DeleteNoteUseCase(noteRepository = get())
	}

	factory<EditNoteUseCase> {
		EditNoteUseCase(noteRepository = get())
	}
}