package com.example.android_e_learning.TeacherThread;

import java.util.ArrayList;

import com.example.android_e_learning.*;
public class TeacherDeleteThread extends Thread{
    TeacherDatabase teacherDatabase;



    public TeacherDeleteThread(TeacherDatabase teacherDatabase) {
        this.teacherDatabase= teacherDatabase;
    }

    @Override
    public void run() {
        ArrayList<Teacher_Room> teacher_rooms = (ArrayList<Teacher_Room>) teacherDatabase.teacher_room_dao().getAll();
        Teacher_Room[] teachers= new Teacher_Room[teacher_rooms.size()];
        teacher_rooms.toArray(teachers);
        teacherDatabase.teacher_room_dao().delete(teachers);

    }
}
