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
    EditText title, content;
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
            String strOfTitle = title.getText().toString();
            String strOfContent = content.getText().toString();
            String strOfDate = new Date().toString();

            // Delegate to NoteController (MVC Controller)
            controller.saveNote(strOfTitle, strOfContent, strOfDate);
        });
    }
    void displayTextNote(TextNote note) {
        showNote.setText(note.getSummary());
    }
}