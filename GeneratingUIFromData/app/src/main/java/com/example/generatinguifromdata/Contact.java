package com.example.generatinguifromdata;

public class Contact {
    private String personName;
    private String phoneNumber;
    private String email;

    public Contact(String personName, String phoneNumber, String email){
        this.personName = personName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPersonName(){
        return this.personName;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getEmail(){
        return this.email;
    }
}
