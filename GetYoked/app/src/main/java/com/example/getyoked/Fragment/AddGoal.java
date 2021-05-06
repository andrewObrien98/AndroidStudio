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

public class AddGoal extends Fragment {
    private boolean previouslySaving = false;
    AddGoal(){
        super(R.layout.add_goal);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        workoutViewModel viewModel = new ViewModelProvider(getActivity()).get(workoutViewModel.class);
        viewModel.getSavingGoal().observe(getViewLifecycleOwner(), (savingGoal) -> {
            if(savingGoal && !previouslySaving){
                MaterialButton button = view.findViewById(R.id.add_new_goal);
                button.setEnabled(false);
                button.setText("Saving....");
                previouslySaving = savingGoal;
            } else if(previouslySaving && !savingGoal) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        view.findViewById(R.id.add_new_goal).setOnClickListener(save-> {
            EditText workoutEditText = view.findViewById(R.id.exercise_workout);
            EditText quantityEditText = view.findViewById(R.id.exercise_quantity);
            EditText unitEditText = view.findViewById(R.id.exercise_unit);
            EditText amountEditText = view.findViewById(R.id.exercise_amount);
            EditText unitAmountEditText = view.findViewById(R.id.exercise_amount_unit);
            viewModel.saveGoalEntry(workoutEditText.getText().toString(), quantityEditText.getText().toString(),
                    unitEditText.getText().toString(), amountEditText.getText().toString(), unitAmountEditText.getText().toString());
        });
    }
}
