package com.example.workout;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.workout.Fragments.FrontPage;
import com.example.workout.Fragments.WorkoutPage;
import com.example.workout.UserDataBase.UserDataBase;
import com.example.workout.UserModels.Exercise;
import com.example.workout.UserModels.Users;
import com.example.workout.ViewModel.UserInfo;

import java.util.ArrayList;

public class WorkOutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_main_screen);
        UserInfo userInfo = new UserInfo(getIntent(), Room.databaseBuilder(getApplicationContext(), UserDataBase.class, "user-database").build());
        userInfo.getExercises();
        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container, new FrontPage(userInfo), null)
                    .commit();
        }
        /////////////////////// if they click the workout button //////////////////////////////
        Button workouts = findViewById(R.id.workouts_button);
        workouts.setOnClickListener(view -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container,new WorkoutPage(userInfo), null)
                    .commit();
        });
    }

}
