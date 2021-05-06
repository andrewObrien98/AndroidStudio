package com.example.mvvmcounter.model;

import androidx.lifecycle.MutableLiveData;

public class Counter {
    private MutableLiveData<Integer> count;
    private MutableLiveData<Integer> count2;
    private workout workouts;
    private workout w;
    public Counter(){
        count = new MutableLiveData<>();
        count.setValue(0);
        workouts = new workout(4,5,6);

        count2 = new MutableLiveData<>();
        count2.setValue(1);
    }
    public void incrementCount(int amount){
        count.setValue(count.getValue() + amount);
        count2.setValue(count2.getValue() + amount);
        w.incrementLegs();
        w.incrementArms();
        w.incrementAbs();


    }

    public void decrementCount(int amount){
        count.setValue(count.getValue() - amount);
        count2.setValue(count2.getValue() - amount);

    }

    public MutableLiveData<Integer> getCount(){
        return count;
    }
    public MutableLiveData<Integer> getCount2(){return count2;}
    public MutableLiveData<Integer> getLegs(){return workouts.getLegs();}
}
