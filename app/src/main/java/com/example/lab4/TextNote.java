package com.example.lab4;

public class TextNote extends Note {

    public TextNote() {
        super();
    }

    public TextNote(String title) {
        super(title, "");
    }

    public TextNote(String title, String content) {
        super(title, content);
    }

    @Override
    public String getSummary() {
        return getTitle() + ":" + getContent() + "(" + formatDate() + ")";
    }


    public void setDate(String date) {

    }
}
