package com.meraz.todo.model.data

import androidx.annotation.Keep

@Keep
data class Today(
    val date: Int,
    val day: String,
    val monthYear: String
)