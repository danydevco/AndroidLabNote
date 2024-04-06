package com.example.parcial_2_jg.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="note")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    val nid:Long?=null,

    @ColumnInfo(name ="title")
    val title:String,

    @ColumnInfo(name ="content")
    val content:String,
)
