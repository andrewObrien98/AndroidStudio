package com.example.getyoked.Fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getyoked.GoalEntriesAdapter;
import com.example.getyoked.R;
import com.example.getyoked.viewModels.workoutViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Goals extends Fragment {
    public Goals(){
        super(R.layout.goals);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        workoutViewModel viewModel = new ViewModelProvider(getActivity()).get(workoutViewModel.class);
        ObservableArrayList goalEntries = viewModel.getGoalEntries();
        GoalEntriesAdapter adapter = new GoalEntriesAdapter(goalEntries);
        goalEntries.addOnListChangedCallback(new ObservableList.OnListChangedCallback() {
            @Override
            public void onChanged(ObservableList sender) {
                getActivity().runOnUiThread(() -> {
                    adapter.notifyDataSetChanged();
                });
            }

            @Override
            public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {
                getActivity().runOnUiThread(() -> {
                    adapter.notifyItemRangeChanged(positionStart, itemCount);
                });

            }

            @Override
            public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
                getActivity().runOnUiThread(() -> {
                    adapter.notifyItemRangeInserted(positionStart, itemCount);
                });

            }

            @Override
            public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {
                getActivity().runOnUiThread(() -> {
                    adapter.notifyItemMoved(fromPosition, toPosition);
                });

            }

            @Override
            public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {
                getActivity().runOnUiThread(() -> {
                    adapter.notifyItemRangeRemoved(positionStart, itemCount);
                });

            }
        });


        RecyclerView recyclerView = view.findViewById(R.id.goals_entry_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        view.findViewById(R.id.add_goal).setOnClickListener(v -> {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.main_fragment_container, new AddGoal(), null)
                    .addToBackStack(null)
                    .commit();
        });
    }
}
