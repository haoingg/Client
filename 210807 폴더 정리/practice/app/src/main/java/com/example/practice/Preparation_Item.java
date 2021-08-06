package com.example.practice;

class Preparation_Item {
    boolean checked; //스크롤 후 체크 이상현상을 해결하기 위해선 객체에 반드시 저장하고 있어야 함함
    String ItemString;

    Preparation_Item(boolean b, String t) {
        checked = b;
        ItemString = t;
    }

    public boolean isChecked() {
        return checked;
    }
}