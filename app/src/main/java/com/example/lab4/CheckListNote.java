package com.example.lab4;

import java.util.ArrayList;
import java.util.List;

public class CheckListNote {
    private List<String> checkList;

    public CheckListNote(String title, String content) {
        super();
        this.checkList = new ArrayList<>();
    }

    public List<String> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<String> checkList) {
        this.checkList = checkList;
    }

    public String getSummary() {
        return "CheckListNote: " + getClass() + " (" + checkList.size() + " items)";
    }
}

