package com.sayilir.coder.libraryservice.dto

data class BookIdDto @JvmOverloads constructor(
    val bookId: String? = "",
    val isbn: String? = ""
) {
    companion object {
        fun convert(id: String, isbn: String): BookIdDto {
            return BookIdDto(id, isbn)
        }
    }
}
