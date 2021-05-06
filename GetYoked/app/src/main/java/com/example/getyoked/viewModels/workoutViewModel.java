package com.example.getyoked.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.getyoked.database.AppDatabase;
import com.example.getyoked.models.ExerciseEntry;

import java.util.ArrayList;

public class workoutViewModel extends AndroidViewModel {
    private AppDatabase database;
    private MutableLiveData<Boolean> savingGoal= new MutableLiveData<>();
    private MutableLiveData<Boolean> savingExercise= new MutableLiveData<>();
    private MutableLiveData<String> date = new MutableLiveData<>();
    private ObservableArrayList<ExerciseEntry> GoalEntries = new ObservableArrayList<>();
    private ObservableArrayList<ExerciseEntry> regularEntries = new ObservableArrayList<>();
    private ObservableArrayList<String> dateEntries = new ObservableArrayList<>();
    private String databaseName;

    private MutableLiveData<String> currentDate = new MutableLiveData<>();

    public workoutViewModel(@NonNull Application application) {
        super(application);
        savingGoal.setValue(false);
        savingExercise.setValue(false);
        database = Room.databaseBuilder(application, AppDatabase.class, "workoutdb").build();
        loadGoalEntries();
        loadRegularEntries();
    }

    public MutableLiveData<String> getCurrentDate() {
        return currentDate;
    }


    public MutableLiveData<String> getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date.setValue(date);
    }

    public void setCurrentDate(String entry) {
        this.currentDate.setValue(entry);
    }

    public MutableLiveData<Boolean> getSavingGoal(){
        return savingGoal;
    }

    public MutableLiveData<Boolean> getSavingExercise(){
        return savingExercise;
    }

    public void loadGoalEntries(){//just returns a list with everything
        new Thread(() -> {
            ArrayList<ExerciseEntry> allEntries = (ArrayList<ExerciseEntry>) database.getWorkoutEntriesDao().getAllGoals("Goal");
            GoalEntries.addAll(allEntries);
        }).start();
    }

    public void loadRegularEntries(){
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ArrayList<ExerciseEntry> allEntries = (ArrayList<ExerciseEntry>) database.getWorkoutEntriesDao().getAllGoals("Regular");
            regularEntries.addAll(allEntries);
            loadDateEntries(regularEntries);
        }).start();
    }

    public void loadDateEntries(ObservableArrayList<ExerciseEntry> fullList){
        for(ExerciseEntry entry : fullList){
            if(!dateEntries.contains(entry.date) && entry.date != null && entry.date.length() < 15){
                dateEntries.add(entry.date);
            }
        }
    }

    public ObservableArrayList<String> getDateEntries(){
        return dateEntries;
    }


    public ObservableArrayList<ExerciseEntry> getGoalEntries() {
        return GoalEntries;
    }

    public ObservableArrayList<ExerciseEntry> getRegularEntries(){
        return regularEntries;
    }

    public void saveWorkoutEntry(String workout, String quantity, String unit, String amount, String amountUnit, String date){
        savingExercise.setValue(true);
        new Thread(()-> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ExerciseEntry newEntry = new ExerciseEntry();
            newEntry.type = "Regular";
            newEntry.workout = workout;
            newEntry.quantity = quantity;
            newEntry.unit = unit;
            newEntry.amount = amount;
            newEntry.amountUnit = amountUnit;
            newEntry.date = date;
            newEntry.id = database.getWorkoutEntriesDao().insert(newEntry);
            regularEntries.add(newEntry);

            if(!dateEntries.contains(date)){
                dateEntries.add(date);
            }

            savingExercise.postValue(false);
            this.date.postValue(date);
        }).start();

    }

    public void saveGoalEntry(String workout, String quantity, String unit, String amount, String amountUnit){
        savingGoal.setValue(true);
        new Thread(()-> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ExerciseEntry newEntry = new ExerciseEntry();
            newEntry.type = "Goal";
            newEntry.workout = workout;
            newEntry.quantity = quantity;
            newEntry.unit = unit;
            newEntry.amount = amount;
            newEntry.amountUnit = amountUnit;
            newEntry.id = database.getWorkoutEntriesDao().insert(newEntry);
            //put into a list
            GoalEntries.add(newEntry);
            savingGoal.postValue(false);
        }).start();
    }
}
