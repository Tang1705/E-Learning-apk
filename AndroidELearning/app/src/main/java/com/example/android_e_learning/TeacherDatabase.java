package com.example.android_e_learning;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Teacher_Room.class}, version = 1,exportSchema = false)
public abstract class TeacherDatabase extends RoomDatabase{
    public abstract Teacher_Room_Dao teacher_room_dao();
}
