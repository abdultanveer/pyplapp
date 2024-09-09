package com.example.pyplapp.kotlinexs;

public class Student {
    String name;
    int age;
    String postalAddress;
    boolean isEligible;

    public Student(String name, int age, String postalAddress, boolean isEligible) {
        this.name = name;
        this.age = age;
        this.postalAddress = postalAddress;
        this.isEligible = isEligible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public boolean isEligible() {
        return isEligible;
    }

    public void setEligible(boolean eligible) {
        isEligible = eligible;
    }
}
