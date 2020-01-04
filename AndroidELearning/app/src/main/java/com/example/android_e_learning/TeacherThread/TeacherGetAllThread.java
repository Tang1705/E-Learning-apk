package com.example.android_e_learning.TeacherThread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.android_e_learning.*;
import com.example.android_e_learning.ui.home.HomeFragment;
public class TeacherGetAllThread extends Thread{
    TeacherDatabase teacherDatabase;

    public TeacherGetAllThread(TeacherDatabase teacherDatabase) {
        this.teacherDatabase = teacherDatabase;
    }

    private HomeFragment callback;

    public void setCallback(HomeFragment callback) {
        this.callback = callback;
    }

    public void run() {
        ArrayList<Teacher_Room> teacher_rooms = (ArrayList<Teacher_Room>) teacherDatabase.teacher_room_dao().getAll();
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        Iterator<Teacher_Room> iterator = teacher_rooms.iterator();
        while (iterator.hasNext()) {
            Teacher_Room teacher_room = iterator.next();
            teachers.add(new Teacher(teacher_room.getUserId(),teacher_room.getCourseId(),teacher_room.getName(),teacher_room.getPhoto(),
                    teacher_room.getTelephone(),teacher_room.getEmail(),teacher_room.getDescription()));
        }
        HomeFragment r = (HomeFragment) callback;
        r.setTeachers(teachers);
    }
}
