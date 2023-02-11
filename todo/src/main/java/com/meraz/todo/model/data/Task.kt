package com.meraz.todo.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task(
    var tittle: String,
    var description: String,
    var piority: String,
    @PrimaryKey(autoGenerate = true) var id: Int? = null
){

}
