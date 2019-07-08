package com.example.listviewdemo;

public class Contact {
    String name;
    int number;
    boolean icon;

    public Contact(String name, int number, boolean icon) {
        this.name = name;
        this.number = number;
        this.icon = icon;
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

    public boolean isIcon() {
        return icon;
    }

    public void setIcon(boolean icon) {
        this.icon = icon;
    }
}
