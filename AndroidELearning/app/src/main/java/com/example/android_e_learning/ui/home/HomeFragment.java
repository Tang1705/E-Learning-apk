package com.example.android_e_learning.ui.home;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.android_e_learning.Course;
import com.example.android_e_learning.GetByURL;
import com.example.android_e_learning.Material;
import com.example.android_e_learning.R;
import com.example.android_e_learning.Teacher;
import com.example.android_e_learning.adapter.AdapterHolder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class HomeFragment extends Fragment {
    AdapterHolder adapter;

    @SuppressLint("NewApi")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        String tmp = GetByURL.readParse("http://47.94.107.165:8080/elearn/courses");
        ArrayList<Course> list = new ArrayList<>();

        try {
            list = Analysis(tmp);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        adapter = new AdapterHolder(list, getActivity(), this);


        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return recyclerView;
    }

    private static ArrayList<Course> Analysis(String jsonStr)
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

            String mediaString = GetByURL.readParse("http://tang5618.com:8080/elearn/courses/" + id + "/materials");
            ArrayList<Material> materials = new ArrayList<Material>();
            JSONArray mediaJson = new JSONArray(mediaString);
            if (mediaJson.length() != 0) {
                for (int k = 0; k < mediaJson.length(); k++) {
                    JSONObject material = mediaJson.getJSONObject(k);
                    String mid = material.getString("id");
                    int mediaType = -1;
                    String tmpType = material.getString("materialType");
                    if (tmpType.equals("video"))
                        mediaType = 0;
                    String materialType = material.getString("materialType");
                    String materialUrl = "http:tang5618.com:8080/elearn/materials/" + mid + "/media";
                    String createDate = material.getString("createDate");
                    String mdescription = material.getString("description");
                    int mstatus = Integer.parseInt(material.getString("status"));

                    materials.add(new Material(mid, id, mediaType, materialType, materialUrl, createDate, mdescription, mstatus));

                }
            }

            String teacherString = GetByURL.readParse("http://47.94.107.165:8080/elearn/courses/" + id + "/teachers");
            ArrayList<Teacher> arrayList = new ArrayList<Teacher>();
            JSONArray teacherArray = new JSONArray(teacherString);
            for (int j = 0; j < teacherArray.length(); j++) {
                JSONObject teacherObject = teacherArray.getJSONObject(j);
                String userId = teacherObject.getString("userid");
                String courseId = teacherObject.getString("courseId");
                String teacherName = teacherObject.getString("name");
                String photo = teacherObject.getString("photo");
                String telephone = teacherObject.getString("telephone");
                String email = teacherObject.getString("email");
                String teacherDescription = teacherObject.getString("description");

                Teacher aTeacher = new Teacher(userId, courseId, teacherName, photo, telephone, email, teacherDescription);
                arrayList.add(aTeacher);
            }

            Course c = new Course(Course.SECOND_TYPE, id, name, code, categoryId, description, price,
                    status, openDate, lastUpdate, level, shared, sharedUrl, avatar,
                    bigAvatar, certification, certificationDuration, arrayList, materials);

            list.add(c);
        }
        return list;
    }


}