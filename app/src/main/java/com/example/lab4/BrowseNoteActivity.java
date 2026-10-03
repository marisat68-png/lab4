package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrowseNoteActivity extends AppCompatActivity {
    Button abbButton;
    Button browseButton;
    Button buttonSearch;
    EditText editTextSearch;
    ProgressBar progressBarSearch;
    TextView textViewNoData;
    ListView listViewNotes;

    List<String> allNotes;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_browse_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        editTextSearch = findViewById(R.id.editTextSearch);
        buttonSearch = findViewById(R.id.buttonSearch);
        progressBarSearch = findViewById(R.id.progressBarSearch);
        textViewNoData = findViewById(R.id.textViewNoData);
        listViewNotes = findViewById(R.id.listViewNotes);

        // Request focus on EditText so keyboard can appear and typing works
        editTextSearch.requestFocus();

        // Dummy data
        allNotes = new ArrayList<>(Arrays.asList(
            "บันทึก lab1",
            "บันทึก lab2"
        ));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allNotes);
        listViewNotes.setAdapter(adapter);

        // Real-time search as user types
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                performSearch(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Search button click listener with Thread (2s delay) & ProgressBar
        buttonSearch.setOnClickListener(v -> {
            String query = editTextSearch.getText().toString();

            // Show progress bar, hide list and no data view, disable button
            progressBarSearch.setVisibility(View.VISIBLE);
            listViewNotes.setVisibility(View.GONE);
            textViewNoData.setVisibility(View.GONE);
            buttonSearch.setEnabled(false);

            // Multitasking: Thread with 2 seconds delay
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(() -> {
                    progressBarSearch.setVisibility(View.GONE);
                    buttonSearch.setEnabled(true);
                    performSearch(query);
                });
            }).start();
        });

        // Button "Abb" -> Navigate to abbNote (Add Note Activity)
        abbButton = findViewById(R.id.button4);
        abbButton.setOnClickListener(v -> {
            Intent addIntent = new Intent(BrowseNoteActivity.this, abbNote.class);
            startActivity(addIntent);
        });

        // Button "Back" -> Navigate back to MainActivity
        browseButton = findViewById(R.id.button5);
        browseButton.setOnClickListener(v -> {
            Intent intent = new Intent(BrowseNoteActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void performSearch(String query) {
        String lowerQuery = query.trim().toLowerCase();
        List<String> filteredList = new ArrayList<>();
        for (String note : allNotes) {
            if (note.toLowerCase().contains(lowerQuery)) {
                filteredList.add(note);
            }
        }

        if (filteredList.isEmpty()) {
            listViewNotes.setVisibility(View.GONE);
            textViewNoData.setVisibility(View.VISIBLE);
        } else {
            textViewNoData.setVisibility(View.GONE);
            listViewNotes.setVisibility(View.VISIBLE);
            adapter.clear();
            adapter.addAll(filteredList);
            adapter.notifyDataSetChanged();
        }
    }
}
