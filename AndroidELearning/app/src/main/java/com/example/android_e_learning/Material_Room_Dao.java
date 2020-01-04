package com.example.android_e_learning;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface Material_Room_Dao {
    @Query("SELECT * FROM material_room")
    List<Material_Room> getAll();




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Material_Room[] materials);



    @Delete
    void delete(Material_Room[] materials);
}
