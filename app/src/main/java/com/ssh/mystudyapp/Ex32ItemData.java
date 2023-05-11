package com.ssh.mystudyapp;

public class Ex32ItemData {
    String id;
    String name;
    String hp;


    int age;
    public Ex32ItemData(String id, String name, String hp) {
        this.id = id;
        this.name = name;
        this.hp = hp;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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


}