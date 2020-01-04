package com.example.android_e_learning.ui.home;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.android_e_learning.Course;
import com.example.android_e_learning.CourseDatabase;
import com.example.android_e_learning.CourseThread.CourseGetAllThread;
import com.example.android_e_learning.CourseThread.CourseInsertThread;
import com.example.android_e_learning.Course_Room;
import com.example.android_e_learning.GetByURL;
import com.example.android_e_learning.ListCourseActivity;
import com.example.android_e_learning.Material;
import com.example.android_e_learning.MaterialDatabase;
import com.example.android_e_learning.MaterialThread.MaterialGetAllThread;
import com.example.android_e_learning.MaterialThread.MaterialInsertThread;
import com.example.android_e_learning.Material_Room;
import com.example.android_e_learning.MyApplication;
import com.example.android_e_learning.NetUtil;
import com.example.android_e_learning.PermisionUtils;
import com.example.android_e_learning.R;
import com.example.android_e_learning.Teacher;
import com.example.android_e_learning.TeacherDatabase;
import com.example.android_e_learning.TeacherThread.TeacherGetAllThread;
import com.example.android_e_learning.TeacherThread.TeacherInsertThread;
import com.example.android_e_learning.Teacher_Room;
import com.example.android_e_learning.adapter.AdapterHolder;
import com.example.android_e_learning.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final int REFRESH_COMPLETE = 0X110;
    AdapterHolder adapter;
    private ArrayList<Course> list;
    private ArrayList<Teacher> teacherList;
    private ArrayList<Material> materialList;
    private ArrayList<Course_Room> courses = new ArrayList<Course_Room>();
    private ArrayList<Teacher_Room> teachers = new ArrayList<Teacher_Room>();
    private ArrayList<Material_Room> materials2 = new ArrayList<Material_Room>();
    private FragmentHomeBinding binding;

    public void setCourses(ArrayList<Course> list) {
        this.list = list;
    }

    public void setTeachers(ArrayList<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public void setMaterials(ArrayList<Material> materialList) {
        this.materialList = materialList;
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == REFRESH_COMPLETE) {
                binding.swipeLy.setRefreshing(false);
            }
        }

        ;
    };

    @SuppressLint("NewApi")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.swipeLy.setOnRefreshListener(this);
        binding.swipeLy.setColorSchemeResources(R.color.colorPrimary);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        String tmp = GetByURL.readParse("http://47.94.107.165:8080/elearn/courses");
        ;
        String coursedbPath = "course.db";
        String MAIXINXI_DIR1 = Environment.getExternalStorageDirectory().getPath();
        coursedbPath = MAIXINXI_DIR1 + File.separator + "/Installation" + File.separator + coursedbPath;

        String teacherdbPath = "teacher.db";
        String MAIXINXI_DIR2 = Environment.getExternalStorageDirectory().getPath();
        teacherdbPath = MAIXINXI_DIR2 + File.separator + "/Installation" + File.separator + teacherdbPath;

        String materialdbPath = "material.db";
        String MAIXINXI_DIR3 = Environment.getExternalStorageDirectory().getPath();
        materialdbPath = MAIXINXI_DIR3 + File.separator + "/Installation" + File.separator + materialdbPath;
        list = new ArrayList<>();
        if (NetUtil.getNetWorkStart(MyApplication.getContext()) == 1) {
            PermisionUtils.verifyStoragePermissions(getActivity());
            TeacherDatabase teacherDatabase;
            teacherDatabase = Room.databaseBuilder(getActivity().getApplicationContext(),
                    TeacherDatabase.class, teacherdbPath).build();
            TeacherGetAllThread teacherGetAllThread = new TeacherGetAllThread(teacherDatabase);
            teacherGetAllThread.setCallback(HomeFragment.this);
            teacherGetAllThread.start();

            MaterialDatabase materialDatabase = Room.databaseBuilder(getActivity().getApplicationContext(),
                    MaterialDatabase.class, materialdbPath).build();
            MaterialGetAllThread materialGetAllThread = new MaterialGetAllThread(materialDatabase);
            materialGetAllThread.setCallback(HomeFragment.this);
            materialGetAllThread.start();

            CourseDatabase courseDatabase = Room.databaseBuilder(getActivity().getApplicationContext(),
                    CourseDatabase.class, coursedbPath).build();
            CourseGetAllThread courseGetAllThread = new CourseGetAllThread(courseDatabase);
            courseGetAllThread.setCallback(HomeFragment.this);
            courseGetAllThread.start();

            try {
                teacherGetAllThread.join();
                materialGetAllThread.join();
                courseGetAllThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (Course course : list) {
                ArrayList<Teacher> teacherList2 = null;
                ArrayList<Material> materialList2 = null;
                for (Teacher teacher : teacherList) {
                    if (teacher.getCourseId() == course.getId()) {
                        teacherList2.add(teacher);
                    }
                }

                for (Material material : materialList) {
                    if (material.getCourseId() == course.getId()) {
                        materialList2.add(material);
                    }
                }
                course.setArrayList(teacherList2);
                course.setmArrayList(materialList2);
            }
        } else {
            try {
                //存入数据库
                CourseDatabase courseDatabase = Room.databaseBuilder(getActivity().getApplicationContext(),
                        CourseDatabase.class, coursedbPath).build();
                Course_Room[] course_rooms_array = new Course_Room[courses.size()];
                courses.toArray(course_rooms_array);
                // Toast.makeText(getActivity(),course_rooms_array[0].getId() , Toast.LENGTH_SHORT).show();
                // PermisionUtils.verifyStoragePermissions(getActivity());
                String[] command = {"chmod", "777", coursedbPath.toString()};
                ProcessBuilder builder = new ProcessBuilder(command);
                builder.start();
                CourseInsertThread insertThread = new CourseInsertThread(courseDatabase, course_rooms_array);
                insertThread.start();
                insertThread.join();
                list = Analysis(tmp);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ArrayList<Course> list = new ArrayList<>();

        try {
            list = Analysis(tmp);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        adapter = new AdapterHolder(list, getActivity(), this);

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());

        setHasOptionsMenu(true);

        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);

        SearchManager searchManager = (SearchManager) Objects.requireNonNull(getActivity()).getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);

        assert searchManager != null;
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setQueryHint("Search Latest Courses...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() > 2) {
                    //onLoadingSwipeRefresh(query);
                } else {
                    Toast.makeText(getActivity(), "Type more than two letters!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchMenuItem.getIcon().setVisible(false, false);
    }

    private ArrayList<Course> Analysis(String jsonStr)
            throws JSONException {
        JSONArray jsonArray = null;
        // 初始化list数组对象
        ArrayList<Course> list = new ArrayList<Course>();
        jsonArray = new JSONArray(jsonStr);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String id = jsonObject.getString("id");
            String name = jsonObject.getString("name");
            String code = jsonObject.getString("code");
            String categoryId = jsonObject.getString("categoryId");
            String description = jsonObject.getString("description");
            int price = Integer.parseInt(jsonObject.getString("price"));
            String tmp = jsonObject.getString("status");
            int status = -1;
            if (tmp.equals("open")) status = 1;
            String openDate = jsonObject.getString("openDate");
            String lastUpdate = jsonObject.getString("lastUpdateOn");
            String _tmp = jsonObject.getString("level");
            int level = -1;
            if (_tmp.equals("basic")) level = 1;
            int shared = Integer.parseInt(jsonObject.getString("shared"));
            String sharedUrl = jsonObject.getString("sharedUrl");
            String avatar = "http://47.94.107.165:8080/elearn/courses/" + id + "/photo";
            String bigAvatar = null;
            String certification = jsonObject.getString("certification");
            String certificationDuration = jsonObject.getString("certificationDuration");

            String mediaString = GetByURL.readParse("http://47.94.107.165:8080/elearn/courses/" + id + "/materials");
            ArrayList<Material> materials = new ArrayList<Material>();
            JSONArray mediaJson = new JSONArray(mediaString);
            if (mediaJson.length() != 0) {
                for (int k = 0; k < mediaJson.length(); k++) {
                    JSONObject material = mediaJson.getJSONObject(k);
                    String mid = material.getString("id");
                    int mediaType = -1;
                    String tmpType = material.getString("mediatype");
                    if (tmpType.equals("video"))
                        mediaType = 0;
                    String materialType = material.getString("materialType");
                    String materialUrl = "http://47.94.107.165:8080/elearn/materials/" + mid + "/media";
                    String createDate = material.getString("createDate");
                    String mdescription = material.getString("description");
                    int mstatus = Integer.parseInt(material.getString("status"));

                    materials.add(new Material(mid, id, mediaType, materialType, materialUrl, createDate, mdescription, mstatus));

                }
            }

            {
                String dbPath = "material.db";
                String MAIXINXI_DIR = Environment.getExternalStorageDirectory().getPath();
                dbPath = MAIXINXI_DIR + File.separator + "/Installation" + File.separator + dbPath;
                //存入数据库
                MaterialDatabase materialDatabase = Room.databaseBuilder(getActivity().getApplicationContext(),
                        MaterialDatabase.class, dbPath).build();
                Material_Room[] material_rooms_array = new Material_Room[materials.size()];
                materials2.toArray(material_rooms_array);
                //Toast.makeText(getActivity(),material_rooms_array[0].getId() , Toast.LENGTH_SHORT).show();
                //PermisionUtils.verifyStoragePermissions(getActivity());
                try {
                    String[] command = {"chmod", "777", dbPath.toString()};
                    ProcessBuilder builder = new ProcessBuilder(command);
                    builder.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MaterialInsertThread insertThread = new MaterialInsertThread(materialDatabase, material_rooms_array);
                insertThread.start();
            }


            String teacherString = GetByURL.readParse("http://47.94.107.165:8080/elearn/courses/" + id + "/teachers");
            ArrayList<Teacher> arrayList = new ArrayList<Teacher>();
            JSONArray teacherArray = new JSONArray(teacherString);
            for (int j = 0; j < teacherArray.length(); j++) {
                JSONObject teacherObject = teacherArray.getJSONObject(j);
                String userId = teacherObject.getString("userid");
                String courseId = teacherObject.getString("courseId");
                String teacherName = teacherObject.getString("name");
                String photo = "http://47.94.107.165:8080/elearn/teachers/" + userId + "/photo";
                String telephone = teacherObject.getString("telephone");
                String email = teacherObject.getString("email");
                String teacherDescription = teacherObject.getString("description");

                Teacher aTeacher = new Teacher(userId, courseId, teacherName, photo, telephone, email, teacherDescription);
                arrayList.add(aTeacher);
            }

            try {
                String dbPath = "teacher.db";
                String MAIXINXI_DIR = Environment.getExternalStorageDirectory().getPath();
                dbPath = MAIXINXI_DIR + File.separator + "/Installation" + File.separator + dbPath;
                //存入数据库
                TeacherDatabase teacherDatabase = Room.databaseBuilder(getActivity().getApplicationContext(),
                        TeacherDatabase.class, dbPath).build();
                Teacher_Room[] teacher_rooms_array = new Teacher_Room[teachers.size()];
                teachers.toArray(teacher_rooms_array);
                Toast.makeText(getActivity(), teacher_rooms_array[0].getName(), Toast.LENGTH_SHORT).show();
                //PermisionUtils.verifyStoragePermissions(getActivity());
                String[] command = {"chmod", "777", dbPath.toString()};
                ProcessBuilder builder = new ProcessBuilder(command);
                builder.start();
                TeacherInsertThread insertThread = new TeacherInsertThread(teacherDatabase, teacher_rooms_array);
                insertThread.start();
                insertThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int courseType = -1;
            if (mediaString.length() != 2) {
                if (materials.get(0).getMediaType() == 0) {

                    courseType = Course.FIRST_TYPE;
                } else
                    courseType = Course.SECOND_TYPE;

            } else {
                courseType = Course.SECOND_TYPE;
            }

            Course c = new Course(courseType, id, name, code, categoryId, description, price,
                    status, openDate, lastUpdate, level, shared, sharedUrl, avatar,
                    bigAvatar, certification, certificationDuration, arrayList, materials);

            list.add(c);
        }
        return list;
    }

    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 1000);
        Objects.requireNonNull(getActivity()).finish();
        Intent intent = new Intent(getActivity(), ListCourseActivity.class);
        startActivity(intent);


    }

}