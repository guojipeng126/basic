package com.reflect;

public class Person {

    private String name;
    private String address;

    private Person(String name){
        this.name = name;
        this.address = "default";
    }

    private void setName(String newName){
        this.name = newName;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

}
