package com.meraz.todo.model.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.meraz.todo.model.data.Piority
import com.meraz.todo.model.data.Task

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(media: Task): Long

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM task")
    suspend fun get(): LiveData<List<Task>>

    @Query("UPDATE task SET piority = :piority WHERE id = :id")
    suspend fun setPriority(piority: Piority, id: Int)

    suspend fun updateTask(id: Int, title: String, description: String, piority: Piority)

}