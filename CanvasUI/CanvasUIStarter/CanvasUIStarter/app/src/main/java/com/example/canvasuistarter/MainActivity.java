package com.example.canvasuistarter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.canvasuistarter.api.USUCanvasAPI;
import com.example.canvasuistarter.api.models.Course;
import com.example.canvasuistarter.api.models.UpcomingEvent;
import com.example.canvasuistarter.api.models.User;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = this;
        USUCanvasAPI api = USUCanvasAPI.getInstance(this);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        toolbar.setNavigationOnClickListener(view -> {
            drawerLayout.open();
        });
        api.getUser(new USUCanvasAPI.OnRequestCompleteListener<User>() {
            @Override
            public void onComplete(User[] result, String errorMessage) {
                TextView name = findViewById(R.id.user_name_text_menu);
                name.setText(result[0].name);
            }
        });


        if (savedInstanceState == null) {//this means they are launching the app for the first time and we want to put a fragment there
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container, new courseFragment(), null)
                    .commit();
            api.getCourses(new USUCanvasAPI.OnRequestCompleteListener<Course>() {
                @Override
                public void onComplete(Course[] result, String errorMessage) {
                    RecyclerView recyclerView = findViewById(R.id.recycler_view_course);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(new courseAdapter(result));
                }
            });

            //at the start it will automatically go to courses
        }

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            menuItem.setChecked(true);
            if(menuItem.getItemId() == R.id.User_item){//navigate to user
                getSupportFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container, new userFragment(), null)
                        .commit();
                api.getUser(new USUCanvasAPI.OnRequestCompleteListener<User>() {
                    @Override
                    public void onComplete(User[] result, String errorMessage) {
                        TextView userName = findViewById(R.id.user_name_text);
                        userName.setText(result[0].name);
                    }
                });
            }
            if(menuItem.getItemId() == R.id.Course_item){//navigate to Courses
                getSupportFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container, new courseFragment(), null)
                        .commit();
                api.getCourses(new USUCanvasAPI.OnRequestCompleteListener<Course>() {
                    @Override
                    public void onComplete(Course[] result, String errorMessage) {
                        RecyclerView recyclerView = findViewById(R.id.recycler_view_course);
                        recyclerView.setLayoutManager(new LinearLayoutManager(context));
                        recyclerView.setAdapter(new courseAdapter(result));
                    }
                });
            }
            if(menuItem.getItemId() == R.id.upcoming_events_item){//navigate to upcoming Events
                getSupportFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container, new upcomingEventFragment(), null)
                        .commit();
                api.getUpcomingEvents(new USUCanvasAPI.OnRequestCompleteListener<UpcomingEvent>() {
                    @Override
                    public void onComplete(UpcomingEvent[] result, String errorMessage) {
                        RecyclerView recyclerView = findViewById(R.id.recycler_view_upcoming_event);
                        recyclerView.setLayoutManager(new LinearLayoutManager(context));
                        recyclerView.setAdapter(new upcomingEventAdapter(result));
                    }
                });
                //navigate to upcoming Events
            }
            return true;
        });

    }
}