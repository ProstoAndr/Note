package com.example.tp_project.data.token

class TokenDataSourceImpl(private val dataStore: TokenDataStore) : TokenDataSource {

	override suspend fun get(): TokenModel = dataStore.get()

	override suspend fun edit(data: TokenModel) = dataStore.edit(data)
}