package com.meraz.todo.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.meraz.todo.model.data.Task

@Database(
    entities = [Task::class],
    version = 1,
    exportSchema = false
)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun getTodoDao(): TodoDao

    companion object {

        private var instance: TodoDatabase? = null
        private var LOCK=Any()

    }
    operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
        instance ?: createDatabase(context).also { instance = it }
    }

    private fun createDatabase(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            TodoDatabase::class.java,
            "tododatabase"
        ).build()

}