package com.example.android_e_learning.MaterialThread;

import com.example.android_e_learning.*;
public class MaterialInsertThread extends Thread{
    MaterialDatabase materialDatabase;
    Material_Room[] material_rooms_array;

    public MaterialInsertThread(MaterialDatabase materialDatabase, Material_Room[] material_rooms_array) {
        this.materialDatabase = materialDatabase;
        this.material_rooms_array = material_rooms_array;
    }

    public void run() {
        materialDatabase.material_room_dao().insertAll(material_rooms_array);
    }
}
