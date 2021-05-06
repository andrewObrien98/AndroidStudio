package com.example.workout.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.workout.R;
import com.example.workout.UserModels.Workout;
import com.example.workout.ViewModel.UserInfo;

import java.util.ArrayList;

public class WorkoutPage extends Fragment {
    UserInfo userInfo;
    public WorkoutPage(UserInfo info){
        super(R.layout.workouts_page_fragment);
        userInfo = info;
        userInfo.findDates();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout layout = view.findViewById(R.id.workouts_layout);
        ScrollView scroll = new ScrollView(getContext());
        LinearLayout layout2 = new LinearLayout(getContext());
        layout2.setOrientation(LinearLayout.VERTICAL);
        ArrayList<String> dates = userInfo.getDates();

        TextView text = new TextView(getContext());
        text.setText("The\n\n\n\n" + userInfo.getExercise().size()  + "\n\n\n\n\n\nre is nothing\n\n\n\n\n\n here at \n\n\n\nall");
        layout2.addView(text);
        scroll.addView(layout2);

        new Thread(()-> {//will add all of the dates to it
            dates.forEach(date -> {
                Button button = new Button(getContext());
                button.setText(date + " ");
                button.setOnClickListener((v) -> {
                    getActivity().getSupportFragmentManager()//go here when wanting to look at past workouts
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_container, new Workouts(userInfo, date), null)
                            .commit();
                });
                layout2.addView(button);
            });
            scroll.addView(layout);
        });
        layout.addView(scroll);

        view.findViewById(R.id.add_workout_button).setOnClickListener((v) -> {//go here when wanting to create new workout
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container, new Workouts(userInfo), null)
                    .commit();
        });

    }

}