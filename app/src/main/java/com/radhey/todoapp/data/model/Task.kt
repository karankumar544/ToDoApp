package com.radhey.todoapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
data class Task(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "date") val dateAdded:Long,
    @ColumnInfo(name = "description") val description:String,
)
