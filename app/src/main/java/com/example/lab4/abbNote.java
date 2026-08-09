package com.example.lab4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class abbNote extends AppCompatActivity {
   Button addNot;
   EditText title,content;
   TextView showNote;
    NoteController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abb_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        title = findViewById(R.id.editTextText);
        content = findViewById(R.id.editTextText2);
        addNot = findViewById(R.id.button3);
        showNote = findViewById(R.id.editTextText3);
        controller = new NoteController(this);

        addNot.setOnClickListener(v -> {
            //get data from user (EditText)
            String str0fTitle = title.getText().toString();
            String strOfContent = content.getText().toString();
            String strOfDate = new Date().toString();

            //set data to TextNote Class
            TextNote tNote = new TextNote();
            tNote.setTitle(str0fTitle);
            tNote.setDate(strOfDate);
            tNote.setContent(strOfContent);
            controller.saveNote(str0fTitle, strOfContent, strOfDate);
            //show not (by method of class)
            //  showNote.setTextDirection(tNote.getSummary());
        });
    }
    void displayTextNote(TextNote note) {
        showNote.setText(note.getSummary());
    }
}