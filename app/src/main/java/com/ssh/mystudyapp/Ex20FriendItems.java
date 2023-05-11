package com.ssh.mystudyapp;

public class Ex20FriendItems {

    String name;
    String hp;
    String gender;
    String address;
    int age;

    public Ex20FriendItems() {

    }

    public Ex20FriendItems(String name, String hp, String gender, String address, int age) {
        this.name = name;
        this.hp = hp;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getHp() {

        return hp;
    }

    public void setHp(String hp) {

        this.hp = hp;
    }

    public String getGender() {

        return gender;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }


}
