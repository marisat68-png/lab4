package com.example.lab4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Note {
    private String content;
    private String title;
    private Date createdDate;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdDate = new Date();
    }

    public Note() {
        this.createdDate = new Date();
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String formatDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        return sdf.format(createdDate);
    }

    public String getSummary() {
        return title;
    }
}
