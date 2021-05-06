package com.example.getyoked.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.getyoked.R;
import com.example.getyoked.viewModels.workoutViewModel;
import com.google.android.material.button.MaterialButton;


public class AddWorkout extends Fragment {
    private boolean previouslySaving = false;
    private String date;
    AddWorkout(String date){
        super(R.layout.add_workout);
        this.date = date;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        workoutViewModel viewModel = new ViewModelProvider(getActivity()).get(workoutViewModel.class);
        viewModel.getSavingExercise().observe(getViewLifecycleOwner(), (savingExercise) -> {
            if(savingExercise && !previouslySaving){
                MaterialButton button = view.findViewById(R.id.add_new_workout);
                button.setEnabled(false);
                button.setText("Saving....");
                previouslySaving = savingExercise;
            } else if(previouslySaving && !savingExercise) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        view.findViewById(R.id.add_new_workout).setOnClickListener(save-> {
            EditText workoutEditText = view.findViewById(R.id.exercise_workout);
            EditText quantityEditText = view.findViewById(R.id.exercise_quantity);
            EditText unitEditText = view.findViewById(R.id.exercise_unit);
            EditText amountEditText = view.findViewById(R.id.exercise_amount);
            EditText unitAmountEditText = view.findViewById(R.id.exercise_amount_unit);
            viewModel.saveWorkoutEntry(workoutEditText.getText().toString(), quantityEditText.getText().toString(),
                    unitEditText.getText().toString(), amountEditText.getText().toString(), unitAmountEditText.getText().toString(), date);

        });
    }
}
