package com.example.android_e_learning;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;
@Dao
public interface Teacher_Room_Dao {
    @Query("SELECT * FROM teacher_room")
    List<Teacher_Room> getAll();




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Teacher_Room[] teachers);



    @Delete
    void delete(Teacher_Room[] teachers);
}
