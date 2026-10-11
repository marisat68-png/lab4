package com.example.lab4;

import android.os.Bundle;
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
    Button backButton;
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
        backButton = findViewById(R.id.buttonBack);
        showNote = findViewById(R.id.editTextText3);
        controller = new NoteController(this);

        // Load notes from database
        controller.loadNotes();

        addNot.setOnClickListener(v -> {
            //get data from user (EditText)
            String strOfTitle = title.getText().toString();
            String strOfContent = content.getText().toString();
            String strOfDate = new Date().toString();

            // Delegate to NoteController (MVC Controller)
            controller.saveNote(strOfTitle, strOfContent, strOfDate);
            // Reload notes
            controller.loadNotes();
        });

        backButton.setOnClickListener(v -> finish());
    }

    void displayTextNote(Note note) {
        showNote.setText(note.getSummary());
    }
}
