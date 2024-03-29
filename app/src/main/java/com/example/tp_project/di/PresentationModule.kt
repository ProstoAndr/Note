package com.example.tp_project.di

import com.example.tp_project.presentation.note.create.CreateNoteViewModel
import com.example.tp_project.presentation.note.list.ListNoteViewModel
import com.example.tp_project.presentation.note.list.navigation.ListNoteRouter
import com.example.tp_project.presentation.login.authorization.AuthorizationViewModel
import com.example.tp_project.presentation.login.authorization.navigation.AuthorizationRouter
import com.example.tp_project.presentation.login.registration.RegistrationViewModel
import com.example.tp_project.presentation.login.registration.navigation.RegistrationRouter
import com.example.tp_project.presentation.note.create.navigation.CreateNoteRouter
import com.example.tp_project.presentation.note.edit.EditNoteViewModel
import com.example.tp_project.presentation.note.edit.navigation.EditNoteRouter
import com.example.tp_project.presentation.title.TitleVIewModel
import com.example.tp_project.presentation.title.navigation.TitleRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {

	viewModelOf(::TitleVIewModel)

	viewModelOf(::AuthorizationViewModel)

	viewModelOf(::RegistrationViewModel)

	viewModelOf(::ListNoteViewModel)

	viewModelOf(::CreateNoteViewModel)

	viewModelOf(::EditNoteViewModel)

	factory { TitleRouter(router = get()) }

	factory { AuthorizationRouter(router = get()) }

	factory { RegistrationRouter(router = get()) }

	factory { ListNoteRouter(router = get()) }

	factory { CreateNoteRouter(router = get()) }

	factory { EditNoteRouter(router = get()) }

	fun provideCicerone(): Cicerone<Router> =
		Cicerone.create()

	single { provideCicerone() }

	fun provideCiceroneRouter(cicerone: Cicerone<Router>): Router =
		cicerone.router

	single {
		provideCiceroneRouter(cicerone = get())
	}

	fun provideCiceroneNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder =
		cicerone.getNavigatorHolder()

	single {
		provideCiceroneNavigationHolder(cicerone = get())
	}
}