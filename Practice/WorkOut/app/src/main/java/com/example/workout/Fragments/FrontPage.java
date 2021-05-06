package com.example.workout.Fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.workout.R;
import com.example.workout.ViewModel.UserInfo;

import org.w3c.dom.Text;

public class FrontPage extends Fragment {
    UserInfo userInfo;
    public FrontPage(UserInfo info){
        super(R.layout.workout_front_page_fragment);
        userInfo = info;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView text = view.findViewById(R.id.name_front_page_text);
        text.setText("Welcome " + userInfo.getName());
    }
}
