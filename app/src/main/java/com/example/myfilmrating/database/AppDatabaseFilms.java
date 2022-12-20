package com.example.myfilmrating.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.myfilmrating.database.Entity.Film;
import com.example.myfilmrating.database.dao.FilmDao;

@Database(entities = {Film.class}, version = 1)
public abstract class AppDatabaseFilms extends RoomDatabase {

  public static AppDatabaseFilms INSTANCE;

  public static AppDatabaseFilms getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = Room.databaseBuilder(context, AppDatabaseFilms.class, "FilmsDB.db  ")
          .allowMainThreadQueries()
          .fallbackToDestructiveMigration()
          .build();
    }
    return INSTANCE;
  }

  public abstract FilmDao filmDao();

}
