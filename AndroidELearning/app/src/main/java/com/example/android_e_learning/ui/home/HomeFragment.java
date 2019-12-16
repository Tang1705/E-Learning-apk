package com.example.android_e_learning.ui.home;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.android_e_learning.adapter.AdapterHolder;
import com.example.android_e_learning.Course;
import com.example.android_e_learning.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    AdapterHolder adapter;


    @SuppressLint("NewApi")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<Course> list = new ArrayList<>();
        String tmp = readParse("http://47.94.107.165:8080/elearn/courses");
        System.out.println(tmp);

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

    @SuppressLint("ObsoleteSdkInt")
    private static String readParse(String urlPath) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        URL url;
        try {
            url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);}
            InputStream inStream = conn.getInputStream();
            while ((len = inStream.read(data)) != -1) {
                outStream.write(data, 0, len);
            }
            inStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String a = new String(outStream.toByteArray());//通过out.Stream.toByteArray获取到写的数据
        return a;
    }

    private static ArrayList<Course> Analysis(String jsonStr)
            throws JSONException {
        JSONArray jsonArray = null;
        // 初始化list数组对象
        ArrayList<Course> list = new ArrayList<Course>();
        jsonArray = new JSONArray(jsonStr);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            // 初始化map数组对象
            String id=jsonObject.getString("id");
            String name=jsonObject.getString("name");
            String code=jsonObject.getString("code");
            String categoryId=jsonObject.getString("categoryId");
            String description=jsonObject.getString("description");
            int price= Integer.parseInt(jsonObject.getString("price"));
            String tmp=jsonObject.getString("status");
            int status=-1;
            if(tmp.equals("open")) status=1;
            String openDate=jsonObject.getString("openDate");
            String lastUpdate=jsonObject.getString("lastUpdateOn");
            String _tmp=jsonObject.getString("level");
            int level=-1;
            if(_tmp.equals("basic")) level=1;
            int shared=Integer.parseInt(jsonObject.getString("shared"));
            String sharedUrl=jsonObject.getString("sharedUrl");
            String avatar="http://47.94.107.165:8080/elearn/courses/"+id+"/photo";
            String bigAvatar=null;
            String certification=jsonObject.getString("certification");
            String certificationDuration=jsonObject.getString("certificationDuration");
            Course c = new Course(Course.SECOND_TYPE, id, name, code,  categoryId,  description,  price,
            status,  openDate,  lastUpdate, level,  shared,  sharedUrl, avatar,
                     bigAvatar,  certification,  certificationDuration);

            list.add(c);
        }
        return list;
    }


    @Override
    public void onRefresh() {


    }

    private void onLoadingSwipeRefresh(final String keyword) {


    }


}