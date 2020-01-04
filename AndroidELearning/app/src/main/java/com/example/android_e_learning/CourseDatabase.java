package com.example.android_e_learning;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Course_Room.class}, version = 1,exportSchema = false)
public abstract class CourseDatabase extends RoomDatabase {
    public abstract Course_Room_Dao course_room_dao();
}
