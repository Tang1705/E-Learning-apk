package com.example.android_e_learning.CourseThread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.android_e_learning.*;
import com.example.android_e_learning.ui.home.HomeFragment;

public class CourseGetAllThread extends Thread{
    CourseDatabase courseDatabase;
    ArrayList<Teacher> arrayList;
    ArrayList<Material> mArrayList;


    public CourseGetAllThread(CourseDatabase courseDatabase) {
        this.courseDatabase = courseDatabase;
    }

    private HomeFragment callback;

    public void setCallback(HomeFragment callback) {
        this.callback = callback;
    }

    public void run() {
        ArrayList<Course_Room> course_rooms = (ArrayList<Course_Room>) courseDatabase.course_room_dao().getAll();
        ArrayList<Course> courses = new ArrayList<Course>();
        Iterator<Course_Room> iterator = course_rooms.iterator();
        while (iterator.hasNext()) {
            Course_Room course_room = iterator.next();
            courses.add(new Course(course_room.getType(),course_room.getId(), course_room.getName(),course_room.getCode(),course_room.getCategoryId(),
                    course_room.getDescription(), course_room.getPrice(),course_room.getStatus(),course_room.getOpenDate(),course_room.getLastUpdate(),
                    course_room.getLevel(),course_room.getShared(),course_room.getSharedUrl(),course_room.getAvatar(),course_room.getBigAvatar(),
                    course_room.getCertification(),course_room.getCertificationDuration(),arrayList,mArrayList));
        }
        HomeFragment r = (HomeFragment) callback;
        r.setCourses(courses);
    }
}
