package com.example.android_e_learning.CourseThread;

import com.example.android_e_learning.*;
public class CourseInsertThread extends Thread{
    private CourseDatabase courseDatabase;
    private Course_Room[] course_rooms_array;

    public CourseInsertThread(CourseDatabase courseDatabase, Course_Room[] course_rooms_array) {
        this.courseDatabase = courseDatabase;
        this.course_rooms_array = course_rooms_array;
    }

    public void run() {
        courseDatabase.course_room_dao().insertAll(course_rooms_array);
    }
}
