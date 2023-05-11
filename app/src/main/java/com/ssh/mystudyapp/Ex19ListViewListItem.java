package com.ssh.mystudyapp;

public class Ex19ListViewListItem {

    String name;
    String hp;

    int resId;

    public Ex19ListViewListItem(String name, String hp, int tel) {
        this.name = name;
        this.hp = hp;
        this.resId = resId; //resource Id
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

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}