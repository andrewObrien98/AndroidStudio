package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.models.Todo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    AppDatabase database;
    ArrayList<Todo> todos = new ArrayList<>();
    LinearLayout mainLayout;
    int newTodoCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").build();
        //todos-database

        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        AppCompatButton button = new AppCompatButton(this);
        button.setText("Generate new Todo");
        new Thread(() -> {
            todos = (ArrayList<Todo>) database.getTodoDao().getAllTodos();
            renderTodos();
        }).start();

        button.setOnClickListener(view -> {
            Todo todo = new Todo();
            todo.contents = "I am a new todo " + newTodoCounter++;
            new Thread(() -> {
                database.getTodoDao().insert(todo);
            }).start();

        });
        mainLayout.addView(button);
        setContentView(mainLayout);
    }

    public void renderTodos() {
        runOnUiThread(() -> {
           todos.forEach(todo -> {
               AppCompatTextView textView = new AppCompatTextView(this);
               textView.setText(todo.contents);
               mainLayout.addView(textView);
           });
        });
    }
}