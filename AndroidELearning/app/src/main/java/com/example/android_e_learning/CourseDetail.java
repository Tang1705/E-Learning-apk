package com.example.android_e_learning;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;

public class CourseDetail extends AppCompatActivity {
    private View layout;
    private FadingScrollView fadingScrollView;
    private ImageButton backButton;
    private ImageButton shareButton;
    private Toolbar toolbar;
    private TextView courseNameView;
    private ImageView avatar;
    private TextView openDateView;
    private TextView enrollView;
    private TextView descriptionView;
    private ImageView tPhotoView;
    private TextView tNameView;
    private TextView tDescriptionView;
    private TextView tEmailView;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_course_detail);

        Course course = (Course) getIntent().getSerializableExtra("courseData");
        String courseName = course.getName();
        courseNameView = (TextView) findViewById(R.id.coursenamedetail);
        courseNameView.setText(courseName);

        avatar = (ImageView) findViewById(R.id.nac_image);
        String imageUrl = course.getAvatar();

        Glide.with(this).load(imageUrl).into(avatar);

        openDateView = (TextView) findViewById(R.id.opendate);
        String openDate = course.getOpenDate();

        openDate = openDate.substring(0, 10);
        openDate = "Open Date: " + openDate;
        openDateView.setText(openDate);

        enrollView = (TextView) findViewById(R.id.enrollment);
        String en = String.valueOf(course.getShared());
        enrollView.setText("Enrollment: " + en);

        descriptionView = (TextView) findViewById(R.id.description);
        String description = course.getDescription();
        description = "       " + description;
        descriptionView.setText(description);

        Teacher teacher = course.getArrayList().get(0);

        tPhotoView = (ImageView) findViewById(R.id.teacherphoto);
        String photo = teacher.getPhoto();
        Glide.with(this).load(photo).into(tPhotoView);

        tNameView = (TextView) findViewById(R.id.teachername);
        String tName = teacher.getName();
        tNameView.setText(tName);

        tDescriptionView = (TextView) findViewById(R.id.teacherdescription);
        String tDescription = teacher.getDescription();
        tDescriptionView.setText(tDescription);

        tEmailView = (TextView) findViewById(R.id.teacheremail);
        String tEmail = teacher.getEmail();
        tEmailView.setText(tEmail);


        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        shareButton = (ImageButton) findViewById(R.id.share);
        shareButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Share");
                intent.putExtra(Intent.EXTRA_TEXT, "This is the share from E-Learn !");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(intent, "Please select the destination to share."));
            }

        });


        backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
            }
        });


        layout = findViewById(R.id.nac_layout);
        layout.setAlpha(0);

        fadingScrollView = (FadingScrollView) findViewById(R.id.nac_root);
        fadingScrollView.setFadingView(layout);
        fadingScrollView.setFadingHeightView(findViewById(R.id.nac_image));
    }


}
