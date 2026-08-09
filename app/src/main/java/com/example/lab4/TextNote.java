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

    // Compatibility method for older code
    public void setDate(String date) {
        // Since we use Date object now, we could parse it, 
        // but for now let's just ignore it or set a default.
    }
}
