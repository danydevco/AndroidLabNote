package com.example.parcial_2_jg.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcial_2_jg.data.model.NoteModel

@Database(entities = [NoteModel::class], version = 1, exportSchema = false)

abstract class AppDataBase: RoomDatabase() {
    abstract fun noteDao():NoteDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase?=null

        fun getInstance(context: Context):AppDataBase{
            return INSTANCE?: synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    name = "notas_database_parcial"
                ).build()
                INSTANCE=instance
                instance
            }
        }
    }
}
