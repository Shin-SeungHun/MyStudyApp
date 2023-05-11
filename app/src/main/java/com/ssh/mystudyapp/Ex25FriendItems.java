package com.ssh.mystudyapp;

public class Ex25FriendItems {

    String name;
    String hp;
    String gender;
    String addr;
    int age;

    public Ex25FriendItems() {

    }

    @Override
    public String toString() {
        return "Ex25FriendItems{" +
                "name='" + name + '\'' +
                ", hp='" + hp + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + addr + '\'' +
                ", age=" + age +
                '}';
    }

    public Ex25FriendItems(String name, String hp, String gender, String address, int age) {
        this.name = name;
        this.hp = hp;
        this.gender = gender;
        this.addr = address;
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

        return addr;
    }

    public void setAddress(String address) {

        this.addr = address;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }


}
