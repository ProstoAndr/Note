package com.example.tp_project.data.token

import com.example.tp_project.domain.ErrorType

class TokenModelConverter {

	fun convert(from: TokenModel): ErrorType = ErrorType(from.errorType)
}