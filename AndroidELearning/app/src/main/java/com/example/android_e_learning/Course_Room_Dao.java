package com.example.android_e_learning;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Course_Room_Dao {
    @Query("SELECT * FROM course_room")
    List<Course_Room> getAll();




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Course_Room[] course);



    @Delete
    void delete(Course_Room[] courses);
}
