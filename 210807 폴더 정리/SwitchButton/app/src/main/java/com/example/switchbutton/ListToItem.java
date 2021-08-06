package com.example.switchbutton;



public class ListToItem {
    boolean checked;
    String ItemString;
    ListToItem(boolean b, String t) {
        checked = b;
        ItemString = t;
    }

    public boolean isChecked(){
        return checked;
    }
}
