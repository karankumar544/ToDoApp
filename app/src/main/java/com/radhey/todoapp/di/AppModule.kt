package com.radhey.todoapp.di

import android.app.Application
import androidx.room.Room
import com.radhey.todoapp.data.model.TaskDao
import com.radhey.todoapp.data.model.TaskDatabase
import com.radhey.todoapp.util.util.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTaskDB(application: Application): TaskDatabase {
        return Room.databaseBuilder(
            application, TaskDatabase::class.java, DATABASE_NAME
        ).build()

    }

    @Provides
    fun provideTaskDao(taskDatabase: TaskDatabase): TaskDao {
        return taskDatabase.getTaskDao()
    }

}