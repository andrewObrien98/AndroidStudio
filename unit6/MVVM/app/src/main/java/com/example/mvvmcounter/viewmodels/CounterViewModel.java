package com.example.mvvmcounter.viewmodels;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmcounter.model.Counter;
import com.example.mvvmcounter.model.workout;

public class CounterViewModel {
    Counter counter;

    public CounterViewModel(){
        counter = new Counter();
    }

    public MutableLiveData<Integer> getCount() {
        return counter.getCount();
    }
    public MutableLiveData<Integer> getCount2(){return counter.getCount2();}
    public MutableLiveData<Integer> getWorkouts(){return counter.getLegs();}

    public void increment(){
        counter.incrementCount(1);

    }
    public void decrement(){
        counter.decrementCount(1);
    }
}
