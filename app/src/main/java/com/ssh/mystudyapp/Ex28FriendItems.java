package com.ssh.mystudyapp;

public class Ex28FriendItems {

    String name;
    String hp;
    String gender;
    String addr;
    int age;

    public Ex28FriendItems() {

    }

    @Override
    public String toString() {
        return "Ex28FriendItems{" +
                "name='" + name + '\'' +
                ", hp='" + hp + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + addr + '\'' +
                ", age=" + age +
                '}';
    }

    public Ex28FriendItems(String name, String hp, String gender, String addr, int age) {
        this.name = name;
        this.hp = hp;
        this.gender = gender;
        this.addr = addr;
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

    public String getAddr() {

        return addr;
    }

    public void setAddr(String addr) {

        this.addr = addr;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }


}
