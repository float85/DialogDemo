package com.example.listviewdemo;

public class ContactNew {
    String name;
    int number;
    String diachi;
    boolean iconAvata;

    public ContactNew(String name, int number, String diachi, boolean iconAvata) {
        this.name = name;
        this.number = number;
        this.diachi = diachi;
        this.iconAvata = iconAvata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public boolean isIconAvata() {
        return iconAvata;
    }

    public void setIconAvata(boolean iconAvata) {
        this.iconAvata = iconAvata;
    }
}
