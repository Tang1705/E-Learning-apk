package com.example.android_e_learning.CourseThread;

import java.util.ArrayList;

import com.example.android_e_learning.CourseDatabase;
import com.example.android_e_learning.Course_Room;
public class CourseDeleteThread extends Thread{
    CourseDatabase courseDatabase;



    public CourseDeleteThread(CourseDatabase courseDatabase) {
        this.courseDatabase = courseDatabase;
    }

    @Override
    public void run() {
        ArrayList<Course_Room> course_rooms = (ArrayList<Course_Room>) courseDatabase.course_room_dao().getAll();
        Course_Room[] courses= new Course_Room[course_rooms.size()];
        course_rooms.toArray(courses);
        courseDatabase.course_room_dao().delete(courses);

    }
}
