package com.example.android_e_learning.TeacherThread;

import com.example.android_e_learning.*;
public class TeacherInsertThread extends Thread{
    TeacherDatabase teacherDatabase;
    Teacher_Room[] teacher_rooms_array;

    public TeacherInsertThread(TeacherDatabase teacherDatabase, Teacher_Room[] teacher_rooms_array) {
        this.teacherDatabase = teacherDatabase;
        this.teacher_rooms_array = teacher_rooms_array;
    }

    public void run() {
        teacherDatabase.teacher_room_dao().insertAll(teacher_rooms_array);
    }
}
