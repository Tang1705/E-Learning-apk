package com.example.android_e_learning.MaterialThread;

import java.util.ArrayList;

import com.example.android_e_learning.*;
public class MaterialDeleteThread extends Thread{
    MaterialDatabase materialDatabase;



    public MaterialDeleteThread(MaterialDatabase materialDatabase) {
        this.materialDatabase= materialDatabase;
    }

    @Override
    public void run() {
        ArrayList<Material_Room> material_rooms = (ArrayList<Material_Room>) materialDatabase.material_room_dao().getAll();
        Material_Room[] materials= new Material_Room[material_rooms.size()];
        material_rooms.toArray(materials);
        materialDatabase.material_room_dao().delete(materials);

    }
}
