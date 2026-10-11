package com.example.lab4;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class NoteMapper {

    static Gson gson = new Gson();

    // OOP -> Entity
    public static NoteEntity toEntity(Note note) {
        if (note instanceof TextNote) {
            return new NoteEntity(note.getTitle(), "text", null, note.getContent(), note.getCreatedDate());
        } else if (note instanceof CheckListNote) {
            String jsonItems = gson.toJson(((CheckListNote) note).getCheckList());
            return new NoteEntity(note.getTitle(), "checklist", jsonItems, null, note.getCreatedDate());
        }
        return null;
    }

    // Entity -> OOP
    public static Note fromEntity(NoteEntity entity) {
        if (entity.type.equals("text")) {
            TextNote note = new TextNote(entity.title, entity.content);
            note.setCreatedDate(entity.createdDate);
            return note;
        } else if (entity.type.equals("checklist")) {
            List<String> items = gson.fromJson(entity.checklistItemsJson, new TypeToken<List<String>>(){}.getType());
            CheckListNote note = new CheckListNote(entity.title, "");
            note.setCheckList(items);
            note.setCreatedDate(entity.createdDate);
            return note;
        }
        return null;
    }
}
