package com.example.mvvmcounter.model;

import androidx.lifecycle.MutableLiveData;

public class workout {
    private MutableLiveData<Integer> legs;
    private MutableLiveData<Integer> arms;
    private MutableLiveData<Integer> abs;

    workout(int l, int a, int c){
        legs = new MutableLiveData<>();
        arms = new MutableLiveData<>();
        abs = new MutableLiveData<>();
        legs.setValue(l);
        arms.setValue(a);
        abs.setValue(c);
    }

    public void incrementLegs(){
        legs.setValue(legs.getValue() + 1);
    }
    public void incrementArms(){
        arms.setValue(arms.getValue() + 1);
    }
    public void incrementAbs(){
        abs.setValue(arms.getValue() + 1);
    }

    public MutableLiveData<Integer> getLegs(){
        return legs;
    }
    public MutableLiveData<Integer> getArms(){
        return arms;
    }
    public MutableLiveData<Integer> getAbs(){
        return abs;
    }
}
