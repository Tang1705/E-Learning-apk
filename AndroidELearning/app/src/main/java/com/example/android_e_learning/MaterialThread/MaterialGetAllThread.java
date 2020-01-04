package com.example.android_e_learning.MaterialThread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.android_e_learning.*;
import com.example.android_e_learning.ui.home.HomeFragment;
public class MaterialGetAllThread extends Thread{
    MaterialDatabase materialDatabase;

    public MaterialGetAllThread(MaterialDatabase materialDatabase) {
        this.materialDatabase = materialDatabase;
    }

    private HomeFragment callback;

    public void setCallback(HomeFragment callback) {
        this.callback = callback;
    }

    public void run() {
        ArrayList<Material_Room> material_rooms = (ArrayList<Material_Room>) materialDatabase.material_room_dao().getAll();
        ArrayList<Material> materials = new ArrayList<Material>();
        Iterator<Material_Room> iterator = material_rooms.iterator();
        while (iterator.hasNext()) {
            Material_Room material_room = iterator.next();
            materials.add(new Material(material_room.getId(),material_room.getCourseId(),material_room.getMediaType(),material_room.getMaterialType(),material_room.getMaterialUrl(),
                    material_room.getCreateDate(),material_room.getDescription(),material_room.getStatus()));
        }
        HomeFragment r = (HomeFragment) callback;
        r.setMaterials(materials);
    }
}
