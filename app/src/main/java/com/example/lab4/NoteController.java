package com.example.lab4;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

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

        //OOP -> entity
        NoteEntity entity = NoteMapper.toEntity(tNote);

        if (entity != null) {
            //add data to db
            Context context = view;
            Executors.newSingleThreadExecutor().execute(() -> {
                try {
                    // 1. บันทึกข้อมูลลง Database
                    AppDatabase.getInstance(context).noteDao().insert(entity);

                    // 2. แสดง Log เมื่อบันทึกสำเร็จ
                    Log.d("DatabaseAction", "Insert successful: Note saved to database.");
                } catch (Exception e) {
                    // กรณีเกิด Error ระหว่างบันทึก
                    Log.e("DatabaseAction", "Error inserting note: " + e.getMessage());
                }
            });
        }

        //show note (by method of class)
        view.displayTextNote(tNote);
    }

    public void saveCheckListNote(String title, String content, List<String> items) {
        CheckListNote cNote = new CheckListNote(title, content);
        if (items != null) {
            cNote.setCheckList(items);
        }

        //OOP -> entity
        NoteEntity entity = NoteMapper.toEntity(cNote);

        if (entity != null) {
            Context context = view;
            Executors.newSingleThreadExecutor().execute(() -> {
                try {
                    // 1. บันทึกข้อมูลลง Database
                    AppDatabase.getInstance(context).noteDao().insert(entity);

                    // 2. แสดง Log เมื่อบันทึกสำเร็จ
                    Log.d("DatabaseAction", "Insert successful: Note saved to database.");
                } catch (Exception e) {
                    // กรณีเกิด Error ระหว่างบันทึก
                    Log.e("DatabaseAction", "Error inserting note: " + e.getMessage());
                }
            });
        }

        view.displayTextNote(cNote);
    }

    public void loadNotes() {
        Context context = view;
        Executors.newSingleThreadExecutor().execute(() -> {
            List<NoteEntity> entities = AppDatabase.getInstance(context).noteDao().getAll();
            List<Note> notes = new ArrayList<>();
            for (NoteEntity e : entities) {
                Note n = NoteMapper.fromEntity(e);
                if (n != null) {
                    notes.add(n);
                }
            }

            // display on UI thread
            view.runOnUiThread(() -> {
                StringBuilder sb = new StringBuilder();
                for (Note n : notes) {
                    sb.append(n.display()).append("\n");
                }
                view.showNote.setText(sb.toString());
            });
        });
    }
}
