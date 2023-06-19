package com.example.tp_project.di

import com.example.tp_project.data.HeaderInterceptor
import com.example.tp_project.data.note.list.ListNoteApi
import com.example.tp_project.data.note.GetNotesConverter
import com.example.tp_project.data.note.list.ListNoteDataSource
import com.example.tp_project.data.note.list.ListNoteDataSourceImpl
import com.example.tp_project.data.note.list.ListNoteRepositoryImpl
import com.example.tp_project.data.login.authorization.LoginApi
import com.example.tp_project.data.login.authorization.LoginDataSource
import com.example.tp_project.data.login.authorization.LoginDataSourceImpl
import com.example.tp_project.data.login.authorization.LoginRepositoryImpl
import com.example.tp_project.data.login.registration.RegistrationApi
import com.example.tp_project.data.login.registration.RegistrationCredentialsConverter
import com.example.tp_project.data.login.registration.RegistrationDataSource
import com.example.tp_project.data.login.registration.RegistrationDataSourceImpl
import com.example.tp_project.data.login.registration.RegistrationRepositoryImpl
import com.example.tp_project.data.note.create.CreateNoteApi
import com.example.tp_project.data.note.NoteConverter
import com.example.tp_project.data.note.create.CreateNoteDataSource
import com.example.tp_project.data.note.create.CreateNoteDataSourceImpl
import com.example.tp_project.data.note.create.CreateNoteRepositoryImpl
import com.example.tp_project.data.note.edit.NoteApi
import com.example.tp_project.data.note.edit.NoteDataSource
import com.example.tp_project.data.note.edit.NoteDataSourceImpl
import com.example.tp_project.data.note.edit.NoteRepositoryImpl
import com.example.tp_project.data.token.TokenDataSource
import com.example.tp_project.data.token.TokenDataSourceImpl
import com.example.tp_project.data.token.TokenDataStore
import com.example.tp_project.data.token.TokenDataStoreImpl
import com.example.tp_project.domain.note.list.ListNoteRepository
import com.example.tp_project.domain.login.authorization.LoginRepository
import com.example.tp_project.domain.login.registration.RegistrationRepository
import com.example.tp_project.domain.note.create.CreateNoteRepository
import com.example.tp_project.domain.note.edit.NoteRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.Date

private const val BASE_URL = "http://172.30.0.1:8080"

val dataModule = module {

	single<Moshi> {
		Moshi.Builder()
			.add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
			.addLast(KotlinJsonAdapterFactory())
			.build()
	}

	single<Interceptor> {
		HeaderInterceptor(tokenDataSource = get())
	}

	single<OkHttpClient> {
		OkHttpClient.Builder()
			.addInterceptor(get())
			.build()
	}

	single<Retrofit> {
		Retrofit.Builder()
			.addConverterFactory(MoshiConverterFactory.create(get()))
			.baseUrl(BASE_URL)

			.client(get())
			.build()
	}

	fun provideLoginApiService(retrofit: Retrofit) = retrofit.create(LoginApi::class.java)

	single<LoginDataSource> {
		LoginDataSourceImpl(provideLoginApiService(get()))
	}

	single<LoginRepository> {
		LoginRepositoryImpl(
			loginDataSource = get(),
			tokenDataSource = get()
		)
	}

	single<TokenDataStore> {
		TokenDataStoreImpl(context = get())
	}

	single<TokenDataSource> {
		TokenDataSourceImpl(dataStore = get())
	}

	fun provideRegistrationApiService(retrofit: Retrofit) = retrofit.create(RegistrationApi::class.java)

	single<RegistrationDataSource> {
		RegistrationDataSourceImpl(provideRegistrationApiService(get()))
	}

	single {
		RegistrationCredentialsConverter()
	}

	single<RegistrationRepository> {
		RegistrationRepositoryImpl(
			registrationConverter = get(),
			registrationDataSource = get()
		)
	}

	fun provideListNoteApiService(retrofit: Retrofit) = retrofit.create(ListNoteApi::class.java)

	single<ListNoteDataSource> {
		ListNoteDataSourceImpl(provideListNoteApiService(get()))
	}

	single {
		GetNotesConverter()
	}

	single<ListNoteRepository> {
		ListNoteRepositoryImpl(
			getNotesConverter = get(),
			listNoteDataSource = get()
		)
	}

	fun provideCreateNoteApiService(retrofit: Retrofit) = retrofit.create(CreateNoteApi::class.java)

	single<CreateNoteDataSource> {
		CreateNoteDataSourceImpl(provideCreateNoteApiService(get()))
	}

	single {
		NoteConverter()
	}

	single<CreateNoteRepository> {
		CreateNoteRepositoryImpl(
			createNoteDataSource = get(),
			converter = get()
		)
	}

	fun provideNoteApiService(retrofit: Retrofit) = retrofit.create(NoteApi::class.java)

	single<NoteDataSource> {
		NoteDataSourceImpl(provideNoteApiService(get()))
	}

	single<NoteRepository> {
		NoteRepositoryImpl(
			noteDataSource = get(),
			converterNote = get(),
			getNotesConverter = get()
		)
	}
}