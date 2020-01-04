package com.example.android_e_learning;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Material_Room.class}, version = 1,exportSchema = false)
public abstract class MaterialDatabase extends RoomDatabase{
    public abstract Material_Room_Dao material_room_dao();
}
