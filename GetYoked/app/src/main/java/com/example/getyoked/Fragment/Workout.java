package com.example.getyoked.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getyoked.PastWorkoutAdapter;
import com.example.getyoked.R;
import com.example.getyoked.WorkOutEntriesAdapter;
import com.example.getyoked.models.ExerciseEntry;
import com.example.getyoked.viewModels.workoutViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Workout extends Fragment {
    Workout(){
        super(R.layout.workout);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        workoutViewModel viewModel = new ViewModelProvider(getActivity()).get(workoutViewModel.class);
        view.findViewById(R.id.add_workout).setOnClickListener(v -> {
            EditText date = view.findViewById(R.id.date);
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.main_fragment_container, new AddWorkout(date.getText().toString()), null)
                    .addToBackStack(null)
                    .commit();
        });

        viewModel.getDate().observe(getViewLifecycleOwner(), (date) -> {
            ArrayList<ExerciseEntry> entries = new ArrayList<>();
            viewModel.getRegularEntries().forEach(entry -> {
                if(date.equals(entry.date)){
                    entries.add(entry);
                }
                WorkOutEntriesAdapter adapter = new WorkOutEntriesAdapter(entries);
                RecyclerView recyclerView = view.findViewById(R.id.workout_recycler_view);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            });
        });

    }
}
