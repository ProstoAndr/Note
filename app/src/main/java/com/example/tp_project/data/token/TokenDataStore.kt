package com.example.tp_project.data.token

interface TokenDataStore {

	suspend fun get(): TokenModel

	suspend fun edit(data: TokenModel)
}