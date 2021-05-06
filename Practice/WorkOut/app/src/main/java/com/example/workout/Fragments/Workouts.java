package com.example.workout.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.workout.R;
import com.example.workout.UserDataBase.UserDataBase;
import com.example.workout.ViewModel.CreateUser;
import com.example.workout.ViewModel.UserInfo;

import org.w3c.dom.Text;

public class Workouts extends Fragment {
    boolean hasDate;
    String date;
    CreateUser user;
    UserInfo userInfo;
    public Workouts(UserInfo userInfo){
        super(R.layout.workouts_real);
        hasDate = false;
        user = new CreateUser(userInfo.getName(), userInfo.getPassword(), userInfo.getDatabase());
        this.userInfo = userInfo;
    }

    public Workouts(UserInfo userInfo, String d){
        super(R.layout.workouts_real);
        hasDate = true;
        date = d;
        user = new CreateUser(userInfo.getName(), userInfo.getPassword(), userInfo.getDatabase());
        this.userInfo = userInfo;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(!hasDate){
            LinearLayout mainLayout = view.findViewById(R.id.new_workouts_layout);
            ScrollView newWorkouts = new ScrollView(getContext());
            LinearLayout workoutsLayout = new LinearLayout(getContext());
            workoutsLayout.setOrientation(LinearLayout.VERTICAL);
            view.findViewById(R.id.add_new_exercise_to_workout).setOnClickListener((v) -> {
                TextView workout = view.findViewById(R.id.workout_new_workout);
                TextView quantity = view.findViewById(R.id.quantity_new_workout);
                TextView unit = view.findViewById(R.id.unit_new_workout);
                TextView amount = view.findViewById(R.id.amount_new_workout);
                TextView unitAmount = view.findViewById(R.id.unit_amount_new_workout);
                TextView date = view.findViewById(R.id.date_of_workout_text);
                user.addExercise(workout.getText().toString(), quantity.getText().toString(), unit.getText().toString(), amount.getText().toString(), unitAmount.getText().toString(), date.getText().toString());
                AppCompatTextView goal = new AppCompatTextView(getContext());
                goal.setText(workout.getText().toString() + ":  "+  quantity.getText().toString()+"  "+ unit.getText().toString()+"  "+ amount.getText().toString()+"  "+ unitAmount.getText().toString());
                workoutsLayout.addView(goal);
            });
            newWorkouts.addView(workoutsLayout);
            mainLayout.addView(newWorkouts);
        }

        LinearLayout goalLayout = view.findViewById(R.id.goals_layout);
        ScrollView goalsScroll = new ScrollView(getContext());
        LinearLayout goals = new LinearLayout(getContext());
        userInfo.getGoals().forEach(exercise -> {
            AppCompatTextView goal = new AppCompatTextView(getContext());
            goal.setText(exercise.workout + ":  "+  exercise.quantity+"  "+ exercise.unit+"  "+ exercise.amount+"  "+ exercise.amountUnit);
            goals.addView(goal);
        });
    }

}
