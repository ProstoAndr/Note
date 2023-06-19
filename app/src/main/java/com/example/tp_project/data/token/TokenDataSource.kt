package com.example.tp_project.data.token

interface TokenDataSource {

	suspend fun get(): TokenModel

	suspend fun edit(data: TokenModel)
}