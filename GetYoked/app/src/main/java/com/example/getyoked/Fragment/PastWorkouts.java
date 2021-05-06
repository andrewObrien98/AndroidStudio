package com.example.getyoked.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getyoked.PastWorkoutAdapter;
import com.example.getyoked.R;
import com.example.getyoked.models.ExerciseEntry;
import com.example.getyoked.viewModels.workoutViewModel;

import java.util.ArrayList;

public class PastWorkouts extends Fragment {
    PastWorkouts(){
        super(R.layout.past_workouts);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        workoutViewModel viewModel = new ViewModelProvider(getActivity()).get(workoutViewModel.class);

        viewModel.getCurrentDate().observe(getViewLifecycleOwner(), (date) -> {
//            TextView titleView = view.findViewById(R.id.past_workout_date);
//            titleView.setText(date);
            ArrayList<ExerciseEntry> entries = new ArrayList<>();
            viewModel.getRegularEntries().forEach(entry -> {
                if(entry.date != null && entry.date.equals(date)){
                    entries.add(entry);
                }
            });
            PastWorkoutAdapter adapter = new PastWorkoutAdapter(entries);
            RecyclerView recyclerView = view.findViewById(R.id.past_workout_recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapter);
        });
    }
}
