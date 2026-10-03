package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button mButton;
    Button browseNoteButton;
    Button addNoteButton;
    ImageView logoImage;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Note note1 = new Note();
        Note note2 = new Note();
        User user1 = new User();
        User user2 = new User();

        note1.setTitle("Lab3");
        note1.setContent("design diagram,create class and object");
        note1.getSummary();

        TextNote noteA = new TextNote();

        user1.setUsername("marisa");
        user1.setEmail("marisa.t68@psru.ac.th");
        user1.setPassword("123456");
        user1.login();

        user2.setUsername("maprang");
        user2.setEmail("marisa.t68@psru.ac.th");
        user2.setPassword("123654");
        user2.login();

        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(v -> {
            System.out.println("clickkkkk");
            Intent aboutMe = new Intent(getApplicationContext(), AboutMeActivity.class);
            startActivity(aboutMe);
        });

        progressBar = findViewById(R.id.progressBar);

        // Browse with Thread and ProgressBar (Lab 6)
        browseNoteButton = findViewById(R.id.button7);
        browseNoteButton.setOnClickListener(v -> {
            Intent browseNote = new Intent(getApplicationContext(), BrowseNoteActivity.class);
            startActivity(browseNote);
        });

        // Add Note
        addNoteButton = findViewById(R.id.button6);
        addNoteButton.setOnClickListener(v -> {
            Intent addNoteIntent = new Intent(getApplicationContext(), abbNote.class);
            startActivity(addNoteIntent);
        });

        logoImage = findViewById(R.id.imageView);
        logoImage.setImageResource(R.drawable.logo);
    }
}
