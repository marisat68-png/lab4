package com.example.lab4;

public class NoteController {
    //Attribute
    private abbNote view;

    //constructor
    public NoteController(abbNote view) {
        this.view = view;
    }

    public void saveNote(String title, String content, String date) {
        //set data to TextNote Class
        TextNote tNote = new TextNote(title);
        tNote.setContent(content);
        tNote.setDate(date);

        //show note (by method of class)
        view.displayTextNote(tNote);
    }
}
